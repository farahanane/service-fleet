package com.pi.fleetservice.controllers;

import com.pi.fleetservice.entities.Bus;
import com.pi.fleetservice.services.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buses")
public class BusController {

    private final BusService service;

    public BusController(BusService service) {
        this.service = service;
    }

    @PostMapping
    public Bus create(@RequestBody Bus bus) {
        return service.create(bus);
    }

    @GetMapping
    public List<Bus> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Bus getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Bus update(@PathVariable Long id, @RequestBody Bus bus) {
        return service.update(id, bus);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}