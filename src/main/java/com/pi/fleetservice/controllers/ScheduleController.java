package com.pi.fleetservice.controllers;

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
    public Schedule create(@RequestBody Schedule schedule) {
        return service.create(schedule);
    }

    @GetMapping
    public List<Schedule> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Schedule getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Schedule update(@PathVariable Long id, @RequestBody Schedule schedule) {
        return service.update(id, schedule);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}