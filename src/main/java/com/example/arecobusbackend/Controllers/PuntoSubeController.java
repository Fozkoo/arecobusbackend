package com.example.arecobusbackend.Controllers;


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

@RestController
@RequestMapping("/api/puntoSube")
public class PuntoSubeController {

    @Autowired
    private PuntoSubeRepository puntoSubeRepository;

    @GetMapping("/getAllPuntosSube")
    public ResponseEntity<?> getAllPuntosSube() {
        List<Puntosube> puntos = puntoSubeRepository.findAll();

        return ResponseEntity.ok(puntos);
    }
}
