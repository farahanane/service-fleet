package com.pi.fleetservice.services;

import com.pi.fleetservice.entities.Schedule;
import com.pi.fleetservice.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository repository;

    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public Schedule create(Schedule schedule) {
        return repository.save(schedule);
    }

    public List<Schedule> getAll() {
        return repository.findAll();
    }

    public Schedule getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public Schedule update(Long id, Schedule updated) {
        Schedule schedule = getById(id);

        schedule.setDepartureTime(updated.getDepartureTime());
        schedule.setArrivalTime(updated.getArrivalTime());
        schedule.setAvailableSeats(updated.getAvailableSeats());

        schedule.setBus(updated.getBus());
        schedule.setRoute(updated.getRoute());

        return repository.save(schedule);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}