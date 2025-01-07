package com.example.arecobusbackend.Services;

import com.example.arecobusbackend.DTO.BusScheduleDTO;
import com.example.arecobusbackend.DTO.BusesDTO;
import com.example.arecobusbackend.DTO.horariosDTO;
import com.example.arecobusbackend.Models.Bus;
import com.example.arecobusbackend.Repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;




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


    /* esta me trae toda la info de los buses que existan */

    public List<horariosDTO> getBusInfoWithHorarios() {
        List<Object[]> results = busRepository.getBusInfoWithHorarios();

        return results.stream().map(row -> {
            int id = (Integer) row[0];
            int numeroLinea = (Integer) row[1];
            String destino = (String) row[2];
            String puntoPartida = (String) row[3];
            String empresaNombre = (String) row[4];
            int precio = (int) row[5];
            String image = (String) row[6];
            String path = (String) row[7];
            String origen = (String) row[8];
            String horariosConcat = (String) row[9];
            String metodo = (String) row[10];

            List<String> horarios = List.of(horariosConcat.split(", "));

            return new horariosDTO(id, numeroLinea, destino, puntoPartida, empresaNombre, precio, image, path, origen, horarios, metodo);  // origen es null aquí
        }).collect(Collectors.toList());
    }


    /* Esta funcion me trae toda la info pero por id */

    public List<horariosDTO> getBusInfoWithHorariosById(Integer idbus) {
        List<Object[]> results = busRepository.getBusInfoWithHorariosById(idbus);

        return results.stream().map(row -> {
            int id = (Integer) row[0];
            int numeroLinea = (Integer) row[1];
            String destino = (String) row[2];
            String puntoPartida = (String) row[3];
            String empresaNombre = (String) row[4];
            int precio = (int) row[5];
            String image = (String) row[6];
            String path = (String) row[7];
            String origen = (String) row[8];  // Origen
            String horariosConcat = (String) row[9];  // Este es el valor con los horarios concatenados
            String metodo = (String) row[10]; // Este es el valor con el tipo de medio de pago (metodo)

            // Ahora verifica que los horarios estén correctamente asignados
            List<String> horarios = List.of(horariosConcat.split(", ")); // Aquí separas correctamente los horarios

            // Devuelve el DTO con los valores correctamente asignados
            return new horariosDTO(id, numeroLinea, destino, puntoPartida, empresaNombre, precio, image, path, origen, horarios, metodo);
        }).collect(Collectors.toList());
    }



    public List<horariosDTO> getBusInfoconIdDia(Integer iddia) {
        List<Object[]> results = busRepository.getBusInfoConIdDia(iddia);

        return results.stream().map(row -> {
            int id = (Integer) row[0];
            int numeroLinea = (Integer) row[1];
            String destino = (String) row[2];
            String puntoPartida = (String) row[3];
            String empresaNombre = (String) row[4];
            int precio = (int) row[5];
            String image = (String) row[6];
            String path = (String) row[7];  // Mapea el nuevo campo
            String origen = (String) row[8];  // Asume que el campo "origen" está en el índice 9
            String horariosConcat = (String) row[9];
            List<String> horarios = List.of(horariosConcat.split(", "));
            String metodo = (String) row[10];
            return new horariosDTO(id, numeroLinea, destino, puntoPartida, empresaNombre, precio, image, path, origen, horarios, metodo);
        }).collect(Collectors.toList());


    }




    }
