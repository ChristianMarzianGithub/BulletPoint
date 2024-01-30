package com.example.BulletPoints;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BulletPoint {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int Id;
	
	
	private String username;
	private String description;
	private Boolean done;
	private Date targetDate;
	
	public BulletPoint() {
	}
	public BulletPoint(int id, String username, String description, Boolean done, Date targetDate) {
		super();
		this.Id = id;
		this.description = description;
		this.done = done;
		this.targetDate = targetDate;
		this.username = username;
	}
	@Override
	public String toString() {
		return "BulletPoint [id=" + Id + ", description=" + description + ", done=" + done + ", targetDate="
				+ targetDate + "username=" + username + "]";
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
