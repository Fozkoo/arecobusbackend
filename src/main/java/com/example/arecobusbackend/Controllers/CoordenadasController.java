package com.example.arecobusbackend.Controllers;


import com.example.arecobusbackend.DTO.CoordenadasDTO;
import com.example.arecobusbackend.Models.Coodenadas;
import com.example.arecobusbackend.Repositories.CoordenadasRepository;
import com.example.arecobusbackend.Services.CoordenadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coordenadas")
public class CoordenadasController {

    @Autowired
    private CoordenadasService coordenadasService;
    @Autowired
    private CoordenadasRepository coordenadasRepository;

    @CrossOrigin
    @GetMapping("/getAllCoordenadas")
    public ResponseEntity<List<CoordenadasDTO>> obtenerTodasLasCoordenadas() {
        List<CoordenadasDTO> coordenadas = coordenadasService.obtenerTodasLasCoordenadas();
        return new ResponseEntity<>(coordenadas, HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping("/createCoordenadas")
    public ResponseEntity<CoordenadasDTO> crearCoordenada(@Validated @RequestBody CoordenadasDTO coordenadasDTO) {
        try {
            CoordenadasDTO nuevaCoordenada = coordenadasService.guardarCoordenada(coordenadasDTO);
            return new ResponseEntity<>(nuevaCoordenada, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
