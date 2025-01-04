package com.example.arecobusbackend.Controllers;


import com.example.arecobusbackend.Models.Localidad;
import com.example.arecobusbackend.Repositories.LocalidadRepository;
import com.example.arecobusbackend.Services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localidad")
public class LocalidadController {

    @Autowired
    private LocalidadRepository localidadRepository;

    @Autowired
    private LocalidadService localidadservice;

    @CrossOrigin
    @GetMapping("/getAllLocalidades")
    public ResponseEntity<?> getAllLocalidades (){
        return localidadservice.getAllLocalidades();
    }

    @CrossOrigin
    @GetMapping("/getLocalidadById/{id}")
    public ResponseEntity<?> getLocalidadById (@PathVariable int id){
        return localidadservice.getLocalidadById(id);
    }
}
