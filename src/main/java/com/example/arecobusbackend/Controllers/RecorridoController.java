package com.example.arecobusbackend.Controllers;


import com.example.arecobusbackend.DTO.RecorridoCoordenadasDTO;
import com.example.arecobusbackend.Models.Recorrido;
import com.example.arecobusbackend.Repositories.RecorridoRepository;
import com.example.arecobusbackend.Services.RecorridoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recorrido")
public class RecorridoController {

    @Autowired
    private RecorridoService recorridoService;

    @Autowired
    private RecorridoRepository recorridoRepository;

    @CrossOrigin
    @GetMapping("/getRecorridoById/{idrecorrido}")
    public RecorridoCoordenadasDTO getRecorridoCoordenadas(@PathVariable int idrecorrido) {
        return recorridoService.getRecorridoConCoordenadas(idrecorrido);
    }

}
