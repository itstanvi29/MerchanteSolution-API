package com.qa.data;

/**
 * @author tanvig
 *
 */
public class PostData {

	private String userId;
	private String title;
	private String body;

	public PostData() {

	}

	/*
	 * public PostData( String userId, String title, String body) {
	 * 
	 * this.userId = userId; this.title = title; this.body = body; }
	 */

	public String toString() {
		return "Posts--  " + this.userId + " " + this.title + "  " + this.body;
	}

	// getters and setter for Posts
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
