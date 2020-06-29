package com.min.main;

public class TransactionBuilder {
	private Transaction t;

	public TransactionBuilder(Transaction t) {
		this.t = t;
	}

	public TransactionBuilder title(String title) {
		t.setTitle(title);
		return this;
	}

	public TransactionBuilder text(String text) {
		t.setText(text);
		return this;
	}

	public Transaction transaction() {
		return t;
	}

}
