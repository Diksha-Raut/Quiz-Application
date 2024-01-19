package com.diksha.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	
	@ManyToMany
	private List<Question> quetions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuetions() {
		return quetions;
	}

	public void setQuetions(List<Question> quetions) {
		this.quetions = quetions;
	}

	public Quiz(Integer id, String title, List<Question> quetions) {
		super();
		this.id = id;
		this.title = title;
		this.quetions = quetions;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", quetions=" + quetions + "]";
	}

	
}
