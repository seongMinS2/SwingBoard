package com.min.main;

public class Transaction {

	private String title;
	private String text;

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Board [title=" + title + ", text=" + text + "]";
	}
	
	
}
