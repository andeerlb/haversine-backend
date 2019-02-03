package br.coordinates.dto;

import br.coordinates.model.Collaborator;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollaboratorDto implements Serializable {

    private static final long serialVersionUID = 6378598785630704931L;

    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double distance;

    public CollaboratorDto() {
    }

    public CollaboratorDto(Collaborator col){
        this.id = col.getId();
        this.name = col.getName();
        this.latitude = col.getGeolocation().getLatitude().doubleValue();
        this.longitude = col.getGeolocation().getLongitude().doubleValue();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
