package com.pi.fleetservice.controllers;

import com.pi.fleetservice.dto.RouteDTO;
import com.pi.fleetservice.services.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @PostMapping
    public RouteDTO create(@RequestBody RouteDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<RouteDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RouteDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public RouteDTO update(@PathVariable Long id, @RequestBody RouteDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}