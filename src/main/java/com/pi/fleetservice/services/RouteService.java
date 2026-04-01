package com.pi.fleetservice.services;

import com.pi.fleetservice.dto.RouteDTO;
import com.pi.fleetservice.entities.Route;
import com.pi.fleetservice.repositories.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    public RouteDTO create(RouteDTO dto) {
        Route route = convertToEntity(dto);
        return convertToDTO(repository.save(route));
    }

    public List<RouteDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Route getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
    }

    public RouteDTO getById(Long id) {
        return convertToDTO(getEntityById(id));
    }

    public RouteDTO update(Long id, RouteDTO dto) {
        Route route = getEntityById(id);

        route.setDepartureCity(dto.getDepartureCity());
        route.setArrivalCity(dto.getArrivalCity());

        return convertToDTO(repository.save(route));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private RouteDTO convertToDTO(Route route) {
        return new RouteDTO(
                route.getId(),
                route.getDepartureCity(),
                route.getArrivalCity()
        );
    }

    private Route convertToEntity(RouteDTO dto) {
        Route route = new Route();
        route.setDepartureCity(dto.getDepartureCity());
        route.setArrivalCity(dto.getArrivalCity());
        return route;
    }
}