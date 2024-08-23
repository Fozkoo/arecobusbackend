package com.example.arecobusbackend.Controllers;
import com.example.arecobusbackend.Models.Horario;
import com.example.arecobusbackend.Services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horario")
public class HorarioController {



    @Autowired
    private HorarioService horarioService;


    @GetMapping("/proximo/{idempresa}/{iddiasemana}/{horario}")
    public List<Horario> getProximoHorario(@PathVariable int idempresa, @PathVariable int iddiasemana, String horario ){
        return horarioService.getProximoHorario(idempresa,iddiasemana,horario);
    }


    /* TRAE LOS HORARIOS DEL BUS Y DIA ESPECIFICADOS

    @GetMapping("/bus/{idbus}/{diaSemana}")
    public List<horariosDetailsDTO> getBusDetails(@PathVariable("idbus") int idbus,
                                                  @PathVariable("diaSemana") int diaSemana) {
        return horarioService.getBusDetailsWithDay(idbus, diaSemana);
    }

    
     */





}
