package com.cdac.oralcaremanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback_table")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(name = "name")
	private String name;

	@Column(unique = true)
	private String email;

	@Column(name = "subject", length = 100)
	private String subject;

	@Column(name = "message", length = 200)
	private String message;

	public Feedback(Integer id, String name, String email, String subject, String message) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
