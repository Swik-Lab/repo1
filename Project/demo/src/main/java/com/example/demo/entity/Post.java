package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postName;
    private String postContents;
    public Post(Long id, String postName, String postContents) {
		super();
		this.id = id;
		this.postName = postName;
		this.postContents = postContents;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostContents() {
		return postContents;
	}
	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}
	

}

