package com.example.arecobusbackend.Controllers;


import com.example.arecobusbackend.DTO.RecorridoCoordenadasDTO;
import com.example.arecobusbackend.Services.RecorridoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recorrido")
public class RecorridoController {

    @Autowired
    private RecorridoService recorridoService;

    @CrossOrigin
    @GetMapping("getRecorridoById/{idrecorrido}")
    public RecorridoCoordenadasDTO getRecorridoCoordenadas(@PathVariable int idrecorrido) {
        return recorridoService.getRecorridoConCoordenadas(idrecorrido);
    }


}