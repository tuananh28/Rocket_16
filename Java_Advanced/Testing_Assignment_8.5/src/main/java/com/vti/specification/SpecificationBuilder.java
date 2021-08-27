package com.vti.specification;

import java.text.ParseException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.utils.Config;
import com.vti.utils.Utils;

public class SpecificationBuilder<T> {

	private boolean isHigerPriorityOperator(String currentOperator, String prevOperator) {
		return isOperatorAndOr(prevOperator)
				&& getOperatorPriority(prevOperator) >= getOperatorPriority(currentOperator);
	}

	private int getOperatorPriority(String operator) {
		return "AND".equalsIgnoreCase(operator) ? 2 : 1;
	}

	private boolean isOperatorAndOr(String str) {
		return "AND".equalsIgnoreCase(str) || "OR".equalsIgnoreCase(str);
	}

	private Deque<?> parseInputToOperator(String search) throws ParseException {

		Deque<Object> output = new LinkedList<>();
		Deque<String> stack = new LinkedList<>();

		// \\s - matches single whitespace character.
		String[] tokens = search.split("\\s+");
		for (String token : tokens) {
			if (isOperatorAndOr(token)) {
				while (!stack.isEmpty() && isHigerPriorityOperator(token, stack.peek())) {
					output.push(stack.pop().equalsIgnoreCase("OR") ? "OR" : "AND");
				}
				stack.push(token.equalsIgnoreCase("OR") ? "OR" : "AND");

			} else if (token.equals("(")) {
				stack.push("(");

			} else if (token.equals(")")) {
				while (!stack.peek().equals("(")) {
					output.push(stack.pop());
				}
				stack.pop();

			} else {
				output.push(parseTokenToCriteria(token));
			}
		}

		while (!stack.isEmpty())
			output.push(stack.pop());

		return output;
	}

	@SuppressWarnings("deprecation")
	private SearchCriteria parseTokenToCriteria(String token) throws ParseException {

		Pattern pattern = Pattern.compile(Config.REGEX_SEARCH);
		Matcher matcher = pattern.matcher(token);

		while (matcher.find()) {
			String key = matcher.group(1);
			String operator = matcher.group(2);
			String value = matcher.group(4);

			// handling LIKE operator
			String prefixWildcard = matcher.group(3);
			if (!StringUtils.isEmpty(prefixWildcard) && operator.equals("~")) {
				value = "%" + value;
			}

			String endfixWildcard = matcher.group(5);
			if (!StringUtils.isEmpty(endfixWildcard) && operator.equals("~")) {
				value = value + "%";
			}

			// parse value
			if (Utils.isMatchRegex(value, Config.REGEX_DATE_VALUE)) {
				return new SearchCriteria(key, operator, Utils.convertStringToDateObject(value, Config.DATE_PATTERN));

			} else if (Utils.isMatchRegex(value, Config.REGEX_DATE_TIME_VALUE)) {
				return new SearchCriteria(key, operator,
						Utils.convertStringToDateObject(value, Config.DATE_TIME_PATTERN));

			} else {
				return new SearchCriteria(key, operator, value);
			}
		}
		return null;
	}

	private Specification<T> parseOperatorToSpecification(Deque<?> operators) throws ParseException {

		Deque<Specification<T>> specification = new LinkedList<>();

		Collections.reverse((List<?>) operators);

		while (!operators.isEmpty()) {
			Object operator = operators.pop();

			if (operator instanceof SearchCriteria) {
				specification.push(new CustomSpecification<>((SearchCriteria) operator));

				// operator AND, OR
			} else {
				Specification<T> specification1 = specification.pop();
				Specification<T> specification2 = specification.pop();
				if (operator.equals("AND")) {
					specification.push(Specification.where(specification1).and(specification2));
				} else if (operator.equals("OR")) {
					specification.push(Specification.where(specification1).or(specification2));
				}
			}
		}

		return specification.pop();
	}

	@SuppressWarnings("deprecation")
	public Specification<T> build(String search) throws ParseException {

		if (StringUtils.isEmpty(search)) {
			return null;
		}

		Deque<?> operators = parseInputToOperator(search);

		return parseOperatorToSpecification(operators);
	}
}
