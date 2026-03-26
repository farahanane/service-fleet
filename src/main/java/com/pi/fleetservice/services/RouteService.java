package com.pi.fleetservice.services;

import com.pi.fleetservice.entities.Route;
import com.pi.fleetservice.repositories.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public Route create(Route route) {
        return repository.save(route);
    }

    public List<Route> getAll() {
        return repository.findAll();
    }

    public Route getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
    }

    public Route update(Long id, Route updated) {
        Route route = getById(id);
        route.setDepartureCity(updated.getDepartureCity());
        route.setArrivalCity(updated.getArrivalCity());
        return repository.save(route);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}