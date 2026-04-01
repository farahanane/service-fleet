package com.pi.fleetservice.dto;

public class BusDTO {

    private Long id;
    private String plateNumber;
    private int capacity;
    private String status;
    private Long chauffeurId;

    public BusDTO() {}

    public BusDTO(Long id, String plateNumber, int capacity, String status, Long chauffeurId) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.capacity = capacity;
        this.status = status;
        this.chauffeurId = chauffeurId;
    }

    public Long getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public Long getChauffeurId() {
        return chauffeurId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setChauffeurId(Long chauffeurId) {
        this.chauffeurId = chauffeurId;
    }
}