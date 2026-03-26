package com.pi.fleetservice.controllers;

import com.pi.fleetservice.entities.Route;
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
    public Route create(@RequestBody Route route) {
        return service.create(route);
    }

    @GetMapping
    public List<Route> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Route getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Route update(@PathVariable Long id, @RequestBody Route route) {
        return service.update(id, route);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}