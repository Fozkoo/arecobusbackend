package com.example.arecobusbackend.Services;


import com.example.arecobusbackend.DTO.CoordenadasDTO;
import com.example.arecobusbackend.Models.Coodenadas;
import com.example.arecobusbackend.Models.Recorrido;
import com.example.arecobusbackend.Repositories.CoordenadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoordenadasService {

    @Autowired
    private CoordenadasRepository coordenadasRepository;

    @Autowired
    private RecorridoService recorridoService;

    public List<CoordenadasDTO> obtenerTodasLasCoordenadas() {
        List<Coodenadas> coordenadas = coordenadasRepository.findAll();
        return coordenadas.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private CoordenadasDTO convertirADTO(Coodenadas coordenada) {
        CoordenadasDTO dto = new CoordenadasDTO();
        dto.setId(coordenada.getIdcoodenadas());
        dto.setLatitud(coordenada.getLatitud());
        dto.setLongitud(coordenada.getLongitud());
        dto.setReferencia(coordenada.getReferencia());


        if (coordenada.getRecorridoByRecorridoIdrecorrido() != null) {
            dto.setRecorridoId(coordenada.getRecorridoByRecorridoIdrecorrido().getIdrecorrido());
        }

        return dto;
    }

    public CoordenadasDTO guardarCoordenada(CoordenadasDTO coordenadasDTO) {
        Coodenadas nuevaCoordenada = new Coodenadas();
        nuevaCoordenada.setLatitud(coordenadasDTO.getLatitud());
        nuevaCoordenada.setLongitud(coordenadasDTO.getLongitud());
        nuevaCoordenada.setReferencia(coordenadasDTO.getReferencia());

        Recorrido recorrido = recorridoService.obtenerPorId(coordenadasDTO.getRecorridoId());
        if (recorrido == null) {
            throw new IllegalArgumentException("El recorrido especificado no existe.");
        }
        nuevaCoordenada.setRecorridoByRecorridoIdrecorrido(recorrido);

        nuevaCoordenada = coordenadasRepository.save(nuevaCoordenada);

        return convertirADTO(nuevaCoordenada);
    }




}
