package com.pi.fleetservice.controllers;

import com.pi.fleetservice.dto.BusDTO;
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
    public BusDTO create(@RequestBody BusDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<BusDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BusDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public BusDTO update(@PathVariable Long id, @RequestBody BusDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}