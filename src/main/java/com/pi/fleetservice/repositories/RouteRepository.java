package com.pi.fleetservice.repositories;
import com.pi.fleetservice.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}