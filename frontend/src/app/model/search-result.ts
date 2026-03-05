import { Book } from "./book";

export interface SearchResult {
    numFound: number;
    docs: Book[];
}
