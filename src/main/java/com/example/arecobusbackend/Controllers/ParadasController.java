package com.example.arecobusbackend.Controllers;


import com.example.arecobusbackend.DTO.ParadasCreateDTO;
import com.example.arecobusbackend.DTO.ParadasDTO;
import com.example.arecobusbackend.Services.ParadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paradas")
public class ParadasController {

    @Autowired
    private ParadasService paradasService;


    @CrossOrigin
    @GetMapping("/getParadasByRecorrido/{idRecorrido}")
    public ResponseEntity<?> getParadasByRecorrido(@PathVariable int idRecorrido) {
        if (idRecorrido <= 0) {
            return ResponseEntity.badRequest().body("El ID del recorrido no es válido");
        }
        return paradasService.getParadasByRecorrido(idRecorrido);
    }

    @CrossOrigin
    @PostMapping("/crearNuevaParada")
    public ResponseEntity<?> crearParada(@RequestBody ParadasCreateDTO paradaCreateDTO) {
            ParadasDTO nuevaParada = paradasService.crearParada(paradaCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaParada);
    }

}
