package com.pi.fleetservice.repositories;
import com.pi.fleetservice.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}