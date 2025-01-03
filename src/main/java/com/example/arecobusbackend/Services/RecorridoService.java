package com.example.arecobusbackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.arecobusbackend.Models.Recorrido;
import com.example.arecobusbackend.DTO.RecorridoCoordenadasDTO;
import com.example.arecobusbackend.Repositories.RecorridoRepository;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecorridoService {

    @Autowired
    private RecorridoRepository recorridoRepository;

    public RecorridoCoordenadasDTO getRecorridoConCoordenadas(int idrecorrido) {
        Recorrido recorrido = recorridoRepository.findById(idrecorrido)
                .orElseThrow(() -> new RuntimeException("Recorrido no encontrado"));


        List<List<Double>> coordenadas = recorrido.getCoodenadasByIdrecorrido().stream()
                .map(coordenada -> List.of(coordenada.getLatitud(), coordenada.getLongitud()))
                .collect(Collectors.toList());


        RecorridoCoordenadasDTO dto = new RecorridoCoordenadasDTO();
        dto.setIdrecorrido(recorrido.getIdrecorrido());
        dto.setCoordenadas(coordenadas);

        return dto;
    }

    public Recorrido obtenerPorId(int id) {
        return recorridoRepository.findById(id).orElse(null);
    }






}