package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Event
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-29T11:14:52.100Z[GMT]")
public class Event   {
  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("place")
  private String place = null;

  @JsonProperty("imageURL")
  private String imageURL = null;

  @JsonProperty("nrOfPlayers")
  private BigDecimal nrOfPlayers = null;

  @JsonProperty("additionalInformation")
  private String additionalInformation = null;

  @JsonProperty("comments")
  @Valid
  private List<Comment> comments = null;

  public Event id(BigDecimal id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public Event name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Event place(String place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")
  
    public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public Event imageURL(String imageURL) {
    this.imageURL = imageURL;
    return this;
  }

  /**
   * Get imageURL
   * @return imageURL
  **/
  @ApiModelProperty(value = "")
  
    public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public Event nrOfPlayers(BigDecimal nrOfPlayers) {
    this.nrOfPlayers = nrOfPlayers;
    return this;
  }

  /**
   * Get nrOfPlayers
   * @return nrOfPlayers
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getNrOfPlayers() {
    return nrOfPlayers;
  }

  public void setNrOfPlayers(BigDecimal nrOfPlayers) {
    this.nrOfPlayers = nrOfPlayers;
  }

  public Event additionalInformation(String additionalInformation) {
    this.additionalInformation = additionalInformation;
    return this;
  }

  /**
   * Get additionalInformation
   * @return additionalInformation
  **/
  @ApiModelProperty(value = "")
  
    public String getAdditionalInformation() {
    return additionalInformation;
  }

  public void setAdditionalInformation(String additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  public Event comments(List<Comment> comments) {
    this.comments = comments;
    return this;
  }

  public Event addCommentsItem(Comment commentsItem) {
    if (this.comments == null) {
      this.comments = new ArrayList<Comment>();
    }
    this.comments.add(commentsItem);
    return this;
  }

  /**
   * Get comments
   * @return comments
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.id, event.id) &&
        Objects.equals(this.name, event.name) &&
        Objects.equals(this.place, event.place) &&
        Objects.equals(this.imageURL, event.imageURL) &&
        Objects.equals(this.nrOfPlayers, event.nrOfPlayers) &&
        Objects.equals(this.additionalInformation, event.additionalInformation) &&
        Objects.equals(this.comments, event.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, place, imageURL, nrOfPlayers, additionalInformation, comments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    imageURL: ").append(toIndentedString(imageURL)).append("\n");
    sb.append("    nrOfPlayers: ").append(toIndentedString(nrOfPlayers)).append("\n");
    sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
