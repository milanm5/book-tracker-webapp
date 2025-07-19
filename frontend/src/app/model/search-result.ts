import { Book } from "./book";

export class SearchResult {

    constructor(
        public numFound: number,
        public docs: Book[]
    ) {}

    public getNumFound() {
        return this.numFound;
    }

    public getDocs() {
        return this.getDocs;
    }

    public setNumFound(numFound: number) {
        this.numFound = numFound;
    }

    public setDocs(docs: Book[]) {
        this.docs = docs;
    }
}
