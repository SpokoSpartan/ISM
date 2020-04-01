package io.swagger.api.response;

import java.util.Date;

public class CommentResponse  implements Comparable<CommentResponse>  {

    private Long id;
    private String content;
    private Long ownerId;
    private Date publicationDate;

    public CommentResponse(Long id, String content, Long ownerId, Date publicationDate) {
        this.id = id;
        this.content = content;
        this.ownerId = ownerId;
        this.publicationDate = publicationDate;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    @Override
    public int compareTo(CommentResponse o) {
        return this.publicationDate.compareTo(o.getPublicationDate());
    }

}
