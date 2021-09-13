package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountFilter;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;
import com.vti.specification.AccountSpecification;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private IAccountRepository accountRepository;
	@Autowired
	private IDepartmentRepository departmentRepository;
	@Autowired
	private IPositionRepository positionRepository;

	@SuppressWarnings("deprecation")
	@Override
	public Page<Account> getAllAccounts(Pageable pageable, String search, AccountFilter filter) {
		Specification<Account> where = null;
		if (!StringUtils.isEmpty(search)) {
			AccountSpecification usernameSpecification = new AccountSpecification("username", "LIKE", search);
			AccountSpecification departmentSpecification = new AccountSpecification("department", "LIKE", search);
			where = Specification.where(usernameSpecification).or(departmentSpecification);
		}
		if (filter != null && filter.getMinDate() != null) {
			AccountSpecification minDateSpecification = new AccountSpecification("createDate", ">=", filter.getMinDate());
			if (where ==  null) {
				where = Specification.where(minDateSpecification);
			}else {
				where = where.and(minDateSpecification);
			}
		}
		if (filter != null && filter.getMaxDate() != null) {
			AccountSpecification maxDateSpecification = new AccountSpecification("createDate", "<=", filter.getMaxDate());
			if (where ==  null) {
				where = Specification.where(maxDateSpecification);
			}else {
				where = where.and(maxDateSpecification);
			}
		}
		return accountRepository.findAll(where, pageable);
	}

	@Override
	public Account getAccountByID(short id) {
		// TODO Auto-generated method stub
		return accountRepository.getById(id);
	}

	@Override
	public void createAccount(AccountFormForCreating form) {
		Account account = new Account();
		Department department = departmentRepository.getById(form.getDepartmentId());
		Position position = positionRepository.getById(form.getPositionId());
		account.setEmail(form.getEmail());
		account.setUsername(form.getUsername());
		account.setFullname(form.getFullname());
		account.setDepartment(department);
		account.setPosition(position);
		accountRepository.save(account);

	}

	@Override
	public void updateAccount(short id, AccountFormForUpdating form) {
		Account account = accountRepository.getById(id);
		Department department = departmentRepository.getById(form.getDepartmentId());
		Position position = positionRepository.getById(form.getPositionId());
		account.setFullname(form.getFullname());
		account.setDepartment(department);
		account.setPosition(position);
		accountRepository.save(account);

	}

	@Override
	public void deleteAccount(short id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void deleteAccounts(List<Short> ids) {
		accountRepository.deleteByIds(ids);
	}
	public UserDetails loadUserByUsername(String username) {
		Account account = accountRepository.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException(username); 
		}
		return new User(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList(account.getRole().toString()));
	}

	@Override
	public Account getAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username);
	}
}