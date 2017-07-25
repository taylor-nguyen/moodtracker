package com.tnguyen.moodtracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * Models to capture user moods
 * 
 * @author Taylor Nguyen
 */
@Entity
@Table(name = "user_mood")
public class UserMood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "mood", nullable = false)
	private String mood;

	@Column(name = "message", length = 350)
	private String message;

	@CreationTimestamp
	@Column(name = "submitted_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date submittedDate;

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the mood
	 */
	public String getMood() {
		return this.mood;
	}

	/**
	 * @param mood the mood to set
	 */
	public void setMood(final String mood) {
		this.mood = mood;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * @return the submittedDate
	 */
	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	/**
	 * @param submittedDate the submitedDate to set
	 */
	public void setSubmittedDate(final Date submittedDate) {
		this.submittedDate = submittedDate;
	}

}
