package com.example.arecobusbackend.Controllers;


import com.example.arecobusbackend.DTO.PuntosubeDTO;
import com.example.arecobusbackend.Models.Puntosube;
import com.example.arecobusbackend.Repositories.PuntoSubeRepository;
import com.example.arecobusbackend.Services.PuntoSubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/puntosSube")
public class PuntoSubeController {

    @Autowired
    private PuntoSubeRepository puntoSubeRepository;

    @CrossOrigin
    @GetMapping("/getAllPuntosSube")
    public ResponseEntity<?> getAllPuntosSube() {
        List<Puntosube> puntos = puntoSubeRepository.findAll();

        // Convertir a DTO
        List<PuntosubeDTO> puntosDTO = puntos.stream().map(p -> new PuntosubeDTO(
                p.getIdpuntosube(),
                p.getLongitud(),
                p.getLatitud(),
                p.getDescripcion(),
                p.getUrlimagen(),
                p.getHorariosapertura(),
                p.getHorariocierre(),
                p.getNombre()
        )).collect(Collectors.toList());

        return ResponseEntity.ok(puntosDTO);
    }
}
