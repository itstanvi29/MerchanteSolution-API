package com.qa.data;

/**
 * @author tanvig
 *
 */
public class CommentsData {

	public CommentsData() {

	}

	/*
	 * public CommentsData(String postId, String name, String email, String body) {
	 * this.postId = postId; this.name = name; this.email = email; this.body = body;
	 * }
	 */
	public String toString() {
		return "Comments --  " + this.postId + " " + this.name + "  " + this.email + " " + this.body;
	}

	public String getpostId() {
		return postId;
	}

	public void setpostId(String postId) {
		this.postId = postId;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	private String postId;
	private String name;
	private String email;
	private String body;
}
