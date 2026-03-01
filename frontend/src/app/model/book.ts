import { Edition } from "./edition";

export class Book {

    constructor(
        public key: string,
        public title: string,
        public author_name: string[],
        public cover_i: string,
        public editions: Edition
    ) {}
}
