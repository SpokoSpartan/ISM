package io.swagger.api.response;

public class EventResponseBuilder {
    private Long id;
    private String name;
    private String place;
    private Integer nrOfPlayers;
    private String imageUrl;
    private Long ownerId;
    private String ownerName;
    private Integer membersAmount;

    public EventResponseBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public EventResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EventResponseBuilder setPlace(String place) {
        this.place = place;
        return this;
    }

    public EventResponseBuilder setNrOfPlayers(Integer nrOfPlayers) {
        this.nrOfPlayers = nrOfPlayers;
        return this;
    }

    public EventResponseBuilder setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public EventResponseBuilder setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public EventResponseBuilder setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public EventResponseBuilder setMembersAmount(Integer membersAmount) {
        this.membersAmount = membersAmount;
        return this;
    }

    public EventResponse createEventResponse() {
        return new EventResponse(id, name, place, nrOfPlayers, imageUrl, ownerId, ownerName, membersAmount);
    }
}