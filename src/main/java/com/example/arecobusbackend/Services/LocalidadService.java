package com.example.arecobusbackend.Services;


import com.example.arecobusbackend.Models.Localidad;
import com.example.arecobusbackend.Repositories.LocalidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocalidadService {

    @Autowired
    private LocalidadRepository localidadrepository;

    public ResponseEntity<?> getAllLocalidades (){
        List<Localidad> localidades = localidadrepository.findAll();
        return ResponseEntity.ok(localidades);
    }

    public ResponseEntity<?> getLocalidadById (int id) {
        Optional<Localidad> localidades = localidadrepository.findById(id);
        return ResponseEntity.ok(localidades);
    }


}
