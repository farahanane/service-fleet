package com.pi.fleetservice.services;

import com.pi.fleetservice.dto.ScheduleDTO;
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

    public Schedule getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public ScheduleDTO getById(Long id) {
        return convertToDTO(getEntityById(id));
    }

    public Schedule update(Long id, Schedule updated) {
        Schedule schedule = getEntityById(id);

        schedule.setDepartureTime(updated.getDepartureTime());
        schedule.setArrivalTime(updated.getArrivalTime());
        schedule.setAvailableSeats(updated.getAvailableSeats());
        schedule.setPrice(updated.getPrice()); // 🔥 important

        schedule.setBus(updated.getBus());
        schedule.setRoute(updated.getRoute());

        return repository.save(schedule);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ScheduleDTO convertToDTO(Schedule schedule) {
        return new ScheduleDTO(
                schedule.getId(),
                schedule.getAvailableSeats(),
                schedule.getPrice(),
                schedule.getBus().getId(),
                schedule.getRoute().getId()
        );
    }
    public void decreaseSeats(Long scheduleId, int seats) {
        Schedule schedule = getEntityById(scheduleId);

        if (schedule.getAvailableSeats() < seats) {
            throw new RuntimeException("Not enough seats");
        }

        schedule.setAvailableSeats(schedule.getAvailableSeats() - seats);

        repository.save(schedule);
    }
}