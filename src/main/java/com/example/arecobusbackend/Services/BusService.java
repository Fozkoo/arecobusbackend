package com.example.arecobusbackend.Services;

import com.example.arecobusbackend.DTO.BusScheduleDTO;
import com.example.arecobusbackend.DTO.BusesDTO;
import com.example.arecobusbackend.Models.Bus;
import com.example.arecobusbackend.Repositories.BusRepository;
import com.example.arecobusbackend.Repositories.BusRepositoryE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusRepositoryE busRepositoryE;

    public List<BusScheduleDTO> getBusSchedules(Long busId, Long dayOfWeekId) {
        return busRepository.findBusSchedulesByBusIdAndDayOfWeek(busId, dayOfWeekId);
    }

    public List<BusesDTO> getAllBuses() {
        // Convertir Iterable a List
        List<Bus> buses = StreamSupport.stream(busRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        // Mapear entidades a DTOs
        return buses.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BusesDTO convertToDTO(Bus bus) {
        BusesDTO dto = new BusesDTO();
        dto.setId(bus.getId());
        dto.setNumeroLinea(bus.getNumeroLinea());
        dto.setDestino(bus.getDestino());
        dto.setEmpresaNombre(bus.getEmpresaIdempresa().getNombre()); // Asumiendo que tienes un getter para nombre
        dto.setPrecio(bus.getPrecio());
        dto.setOrigen(bus.getOrigen());
        dto.setPuntoPartida(bus.getPuntoPartida());
        dto.setImage(bus.getImage());
        return dto;
    }

}
