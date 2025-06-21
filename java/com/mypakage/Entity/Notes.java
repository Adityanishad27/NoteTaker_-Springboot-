package com.mypakage.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	
	@Column(length = 2000)
	private String content;
	private Date addeddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddeddate() {
		return addeddate;
	}
	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}
	@Override
	public String toString() {
		return "Notes [id=" + id + ", title=" + title + ", content=" + content + ", addeddate=" + addeddate + "]";
	}
	public Notes(int id, String title, String content, Date addeddate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.addeddate = addeddate;
	}
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
