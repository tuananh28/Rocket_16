package com.vti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typequestion database table.
 * 
 */
@Entity
@Table(name="typequestion")
@NamedQuery(name="Typequestion.findAll", query="SELECT t FROM Typequestion t")
public class Typequestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private byte typeID;

	@Column(nullable=false, length=1)
	private String typeName;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="typequestion")
	private List<Question> questions;

	public Typequestion() {
	}

	public byte getTypeID() {
		return this.typeID;
	}

	public void setTypeID(byte typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setTypequestion(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setTypequestion(null);

		return question;
	}

}