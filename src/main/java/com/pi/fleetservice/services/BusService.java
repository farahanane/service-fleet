package com.pi.fleetservice.services;

import com.pi.fleetservice.entities.Bus;
import com.pi.fleetservice.repositories.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    private final BusRepository repository;

    public BusService(BusRepository repository) {
        this.repository = repository;
    }

    public Bus create(Bus bus) {
        return repository.save(bus);
    }

    public List<Bus> getAll() {
        return repository.findAll();
    }

    public Bus getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found"));
    }

    public Bus update(Long id, Bus updatedBus) {
        Bus bus = getById(id);
        bus.setPlateNumber(updatedBus.getPlateNumber());
        bus.setCapacity(updatedBus.getCapacity());
        bus.setStatus(updatedBus.getStatus());
        return repository.save(bus);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}