package com.vti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoryquestion database table.
 * 
 */
@Entity
@Table(name="categoryquestion")
@NamedQuery(name="Categoryquestion.findAll", query="SELECT c FROM Categoryquestion c")
public class Categoryquestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private byte categoryID;

	@Column(nullable=false, length=50)
	private String categoryName;

	//bi-directional many-to-one association to Exam
	@OneToMany(mappedBy="categoryquestion")
	private List<Exam> exams;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="categoryquestion")
	private List<Question> questions;

	public Categoryquestion() {
	}

	public byte getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(byte categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Exam addExam(Exam exam) {
		getExams().add(exam);
		exam.setCategoryquestion(this);

		return exam;
	}

	public Exam removeExam(Exam exam) {
		getExams().remove(exam);
		exam.setCategoryquestion(null);

		return exam;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setCategoryquestion(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setCategoryquestion(null);

		return question;
	}

}