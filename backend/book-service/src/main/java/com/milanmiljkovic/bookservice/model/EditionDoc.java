package com.milanmiljkovic.bookservice.model;

public class EditionDoc {
	
	private String key;
	private String title;
	private int cover_i;
	
	public EditionDoc(String key, String title, int cover_i) {
		super();
		this.key = key;
		this.title = title;
		this.cover_i = cover_i;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCover_i() {
		return cover_i;
	}

	public void setCover_i(int cover_i) {
		this.cover_i = cover_i;
	}
}
