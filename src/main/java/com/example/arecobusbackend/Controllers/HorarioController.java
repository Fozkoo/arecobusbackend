package com.example.arecobusbackend.Controllers;

import com.example.arecobusbackend.Models.Empresa;
import com.example.arecobusbackend.Models.Horario;
import com.example.arecobusbackend.Services.EmpresaService;
import com.example.arecobusbackend.Services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class HorarioController {


    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/getAllEmpresa")
    public List<Empresa> getAllEmpresas(){
        return empresaService.getAllEmpresas();
    }

    @GetMapping("/proximo/{idempresa}/{iddiasemana}/{horario}")
    public List<Horario> getProximoHorario(@PathVariable int idempresa, @PathVariable int iddiasemana, String horario ){
        return horarioService.getProximoHorario(idempresa,iddiasemana,horario);
        }

}
