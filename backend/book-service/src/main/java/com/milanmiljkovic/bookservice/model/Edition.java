package com.milanmiljkovic.bookservice.model;

/**
 * 
 */
public class Edition {
	
	private int numFound;
	private Book[] docs;

	public Edition(int numFound, Book[] docs) {
		this.numFound = numFound;
		this.docs = docs;
	}
	
	public int getNumFound() {
		return this.numFound;
	}
	
	public void setNumFound(int numFound) {
		this.numFound = numFound;
	}
	
	public Book[] getDocs() {
		return docs;
	}

	public void setDocs(Book[] docs) {
		this.docs = docs;
	}
	
	
	

}
