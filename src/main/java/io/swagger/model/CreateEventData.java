package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * CreateEventData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-29T11:14:52.100Z[GMT]")
public class CreateEventData {
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

    public CreateEventData name(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateEventData place(String place) {
        this.place = place;
        return this;
    }

    @NotNull
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public CreateEventData imageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public CreateEventData nrOfPlayers(BigDecimal nrOfPlayers) {
        this.nrOfPlayers = nrOfPlayers;
        return this;
    }

    @Valid
    public BigDecimal getNrOfPlayers() {
        return nrOfPlayers;
    }

    public void setNrOfPlayers(BigDecimal nrOfPlayers) {
        this.nrOfPlayers = nrOfPlayers;
    }

    public CreateEventData additionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateEventData createEventData = (CreateEventData) o;
        return Objects.equals(this.name, createEventData.name) &&
                Objects.equals(this.place, createEventData.place) &&
                Objects.equals(this.imageURL, createEventData.imageURL) &&
                Objects.equals(this.nrOfPlayers, createEventData.nrOfPlayers) &&
                Objects.equals(this.additionalInformation, createEventData.additionalInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, imageURL, nrOfPlayers, additionalInformation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateEventData {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    place: ").append(toIndentedString(place)).append("\n");
        sb.append("    imageURL: ").append(toIndentedString(imageURL)).append("\n");
        sb.append("    nrOfPlayers: ").append(toIndentedString(nrOfPlayers)).append("\n");
        sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
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
