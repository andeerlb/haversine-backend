package br.coordinates.dto;

import br.coordinates.model.Store;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreDto {
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double distance;

    public StoreDto(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.latitude = store.getGeolocation().getLatitude().doubleValue();
        this.longitude = store.getGeolocation().getLongitude().doubleValue();
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
