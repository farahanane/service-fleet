package com.pi.fleetservice.repositories;

import com.pi.fleetservice.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}