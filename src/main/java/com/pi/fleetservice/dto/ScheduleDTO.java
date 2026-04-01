package com.pi.fleetservice.dto;

public class ScheduleDTO {

    private Long id;
    private int availableSeats;
    private double price;

    private Long busId;
    private Long routeId;

    public ScheduleDTO() {}

    public ScheduleDTO(Long id, int availableSeats, double price, Long busId, Long routeId) {
        this.id = id;
        this.availableSeats = availableSeats;
        this.price = price;
        this.busId = busId;
        this.routeId = routeId;
    }

    public Long getId() {
        return id;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public Long getBusId() {
        return busId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}