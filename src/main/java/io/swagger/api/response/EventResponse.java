package io.swagger.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventResponse {

    private Long id;
    private String name;
    private String place;
    private Integer nrOfPlayers;
    private String imageUrl;
    private Long ownerId;
    private String ownerName;
    private Integer membersAmount;

    private List<CommentResponse> comments;
    private String additionalInformation;

    private Boolean canVote;

    public EventResponse(Long id, String name, String place, Integer nrOfPlayers,
                         String imageUrl, Long ownerId, String ownerName, Integer membersAmount) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.nrOfPlayers = nrOfPlayers;
        this.imageUrl = imageUrl;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.membersAmount = membersAmount;
    }

    public void setComments(List<CommentResponse> comments) {
        this.comments = comments;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setCanVote(Boolean canVote) {
        this.canVote = canVote;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Used by Jackson
    public String getPlace() {
        return place;
    }

    public Integer getNrOfPlayers() {
        return nrOfPlayers;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Integer getMembersAmount() {
        return membersAmount;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }

    public Boolean getCanVote() {
        return canVote;
    }
}
