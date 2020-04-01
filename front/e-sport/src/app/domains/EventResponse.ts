import {CommentResponse} from "./CommentResponse";

export class EventResponse {

    additionalInformation: string;
    comments: CommentResponse[];
    id: number;
    imageUrl: string;
    membersAmount: number;
    name: string;
    nrOfPlayers: number;
    ownerId: number;
    ownerName: string;
    place: string;
}