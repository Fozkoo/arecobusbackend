package com.example.arecobusbackend.Controllers;

import com.example.arecobusbackend.Services.EmpresaService;
import com.example.arecobusbackend.Services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/getAllEmpresa")
    public ResponseEntity<?> getAllEmpresas(){
        return empresaService.getAllEmpresa();
    }

}
