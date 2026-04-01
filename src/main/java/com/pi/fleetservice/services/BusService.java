package com.pi.fleetservice.services;

import com.pi.fleetservice.dto.BusDTO;
import com.pi.fleetservice.entities.Bus;
import com.pi.fleetservice.repositories.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {

    private final BusRepository repository;

    public BusService(BusRepository repository) {
        this.repository = repository;
    }

    public BusDTO create(BusDTO dto) {
        Bus bus = convertToEntity(dto);
        return convertToDTO(repository.save(bus));
    }

    public List<BusDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Bus getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found"));
    }

    public BusDTO getById(Long id) {
        return convertToDTO(getEntityById(id));
    }

    public BusDTO update(Long id, BusDTO dto) {
        Bus bus = getEntityById(id);

        bus.setPlateNumber(dto.getPlateNumber());
        bus.setCapacity(dto.getCapacity());
        bus.setStatus(dto.getStatus());
        bus.setChauffeurId(dto.getChauffeurId());

        return convertToDTO(repository.save(bus));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BusDTO convertToDTO(Bus bus) {
        return new BusDTO(
                bus.getId(),
                bus.getPlateNumber(),
                bus.getCapacity(),
                bus.getStatus(),
                bus.getChauffeurId()
        );
    }

    private Bus convertToEntity(BusDTO dto) {
        Bus bus = new Bus();
        bus.setPlateNumber(dto.getPlateNumber());
        bus.setCapacity(dto.getCapacity());
        bus.setStatus(dto.getStatus());
        bus.setChauffeurId(dto.getChauffeurId());
        return bus;
    }
}