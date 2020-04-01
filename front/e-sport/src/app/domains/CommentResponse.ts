export class CommentResponse {

    id: number;
    content: string
    ownerId: number;
    publicationDate: Date;

    constructor(id: number, content: string, ownerId: number, publicationDate: Date) {
        this.id = id;
        this.content = content;
        this.ownerId = ownerId;
        this.publicationDate = publicationDate;
    }
}