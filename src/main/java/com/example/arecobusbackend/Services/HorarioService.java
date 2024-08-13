package com.example.arecobusbackend.Services;

import com.example.arecobusbackend.DTO.BusesDTO;
import com.example.arecobusbackend.DTO.horariosDTO;
import com.example.arecobusbackend.DTO.horariosDetailsDTO;
import com.example.arecobusbackend.Models.Horario;
import com.example.arecobusbackend.Repositories.HorarioRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public ResponseEntity<?> getAllHorarios() {
        List<Horario> horarios = horarioRepository.findAll();
        return ResponseEntity.ok(horarios);
    }

    public List<Horario> getProximoHorario(int empresa, int dia, String horarioActual){
        return  horarioRepository.getProximoSalida(empresa,dia,horarioActual);

    }


    /*
    public List<Object[]> getBusDetailsWithDay(int idbus, int diaSemana) {
        return horarioRepository.findBusDetailsWithDay(idbus, diaSemana);
    }


     */







    public List<horariosDetailsDTO> getBusDetailsWithDay(int idbus, int diaSemana) {
        List<Object[]> results = horarioRepository.findBusDetailsWithDay(idbus, diaSemana);

        Map<Integer, horariosDetailsDTO> busesMap = new LinkedHashMap<>();

        for (Object[] result : results) {
            int busId = (int) result[0];
            Time horarioTime = (Time) result[4];  // El valor horario como Time
            String horario = horarioTime.toString();  // Convertir Time a String

            if (!busesMap.containsKey(busId)) {
                horariosDetailsDTO busDetails = new horariosDetailsDTO(
                        (int) result[0],         // idbus
                        (int) result[1],         // numeroLinea
                        (String) result[2],      // destino
                        "puntoPartidaEjemplo",   // Punto de partida (reemplazar con valor real)
                        (String) result[3],      // empresaNombre
                        0,                       // precio (reemplazar con valor real)
                        "imageEjemplo",          // image (reemplazar con valor real)
                        "pathEjemplo",           // path (reemplazar con valor real)
                        new ArrayList<>()        // horarios
                );
                busesMap.put(busId, busDetails);
            }

            busesMap.get(busId).getHorarios().add(horario);  // Agregar el horario convertido a la lista de horarios
        }

        return new ArrayList<>(busesMap.values());
    }





}
