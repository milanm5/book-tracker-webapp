package com.milanmiljkovic.bookservice.model;

/**
 * 
 */
public class Edition {
	
	private int numFound;
	private EditionDoc[] docs;

	public Edition(int numFound, EditionDoc[] docs) {
		this.numFound = numFound;
		this.docs = docs;
	}
	
	public int getNumFound() {
		return this.numFound;
	}
	
	public void setNumFound(int numFound) {
		this.numFound = numFound;
	}
	
	public EditionDoc[] getDocs() {
		return docs;
	}

	public void setDocs(EditionDoc[] docs) {
		this.docs = docs;
	}
	
	
	

}
