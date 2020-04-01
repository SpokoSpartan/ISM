package io.swagger.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String place;
    private Integer nrOfPlayers;
    private String imageUrl;
    @Column(length = 1000)
    private String additionalInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_owner")
    private User owner;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "membert",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    Set<User> members = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_comment")
    private Set<Comment> comments = new HashSet<>();
    private String uuid = UUID.randomUUID().toString();

    // Used by Me
    public Event(String name, String place, Integer nrOfPlayers, String imageUrl, String additionalInfo, User owner) {
        this.name = name;
        this.place = place;
        this.nrOfPlayers = nrOfPlayers;
        this.imageUrl = imageUrl;
        this.additionalInfo = additionalInfo;
        this.owner = owner;
        this.members.add(owner);
    }

    public void addMember(User user) {
        this.members.add(user);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public Integer getNrOfPlayers() {
        return nrOfPlayers;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public User getOwner() {
        return owner;
    }

    public Set<User> getMembers() {
        return members;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    //Needed by JPA :(
    //That sad that spring still require setters :(
    public Event() {
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setNrOfPlayers(Integer nrOfPlayers) {
        this.nrOfPlayers = nrOfPlayers;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(uuid, event.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
