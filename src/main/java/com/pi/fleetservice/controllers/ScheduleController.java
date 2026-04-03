package com.pi.fleetservice.controllers;

import com.pi.fleetservice.dto.ScheduleDTO;
import com.pi.fleetservice.entities.Schedule;
import com.pi.fleetservice.services.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @PostMapping
    public ScheduleDTO create(@RequestBody Schedule schedule) {
        Schedule saved = service.create(schedule);
        return service.convertToDTO(saved);
    }

    // ✅ FIXED HERE
    @GetMapping
    public List<Schedule> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ScheduleDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ScheduleDTO update(@PathVariable Long id, @RequestBody Schedule schedule) {
        Schedule updated = service.update(id, schedule);
        return service.convertToDTO(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/decrease-seats")
    public void decreaseSeats(@PathVariable Long id, @RequestParam int seats) {
        service.decreaseSeats(id, seats);
    }

    @PutMapping("/{id}/increase-seats")
    public void increaseSeats(@PathVariable Long id, @RequestParam int seats) {
        service.increaseSeats(id, seats);
    }
}