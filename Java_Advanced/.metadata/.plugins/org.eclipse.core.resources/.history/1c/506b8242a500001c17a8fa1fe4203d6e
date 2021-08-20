package com.vti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the exam database table.
 * 
 */
@Entity
@Table(name="exam")
@NamedQuery(name="Exam.findAll", query="SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private byte examID;

	@Column(nullable=false, length=10)
	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(nullable=false)
	private byte duration;

	@Column(nullable=false, length=50)
	private String title;

	//bi-directional many-to-one association to Categoryquestion
	@ManyToOne
	@JoinColumn(name="CategoryID", nullable=false)
	private Categoryquestion categoryquestion;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="CreatorID", nullable=false)
	private Account account;

	//bi-directional many-to-many association to Question
	@ManyToMany
	@JoinTable(
		name="examquestion"
		, joinColumns={
			@JoinColumn(name="ExamID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="QuestionID", nullable=false)
			}
		)
	private List<Question> questions;

	public Exam() {
	}

	public byte getExamID() {
		return this.examID;
	}

	public void setExamID(byte examID) {
		this.examID = examID;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getDuration() {
		return this.duration;
	}

	public void setDuration(byte duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Categoryquestion getCategoryquestion() {
		return this.categoryquestion;
	}

	public void setCategoryquestion(Categoryquestion categoryquestion) {
		this.categoryquestion = categoryquestion;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}