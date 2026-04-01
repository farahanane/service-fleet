package com.pi.fleetservice.dto;

public class RouteDTO {

    private Long id;
    private String departureCity;
    private String arrivalCity;

    public RouteDTO() {}

    public RouteDTO(Long id, String departureCity, String arrivalCity) {
        this.id = id;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public Long getId() {
        return id;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }
}