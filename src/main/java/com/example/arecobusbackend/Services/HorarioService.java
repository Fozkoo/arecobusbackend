package com.example.arecobusbackend.Services;

import com.example.arecobusbackend.Models.Horario;
import com.example.arecobusbackend.Repositories.HorarioRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public ResponseEntity<?> getAllHorarios() {
        List<Horario> horarios = horarioRepository.findAll();
        return ResponseEntity.ok(horarios);
    }

    public List<Horario> getProximoHorario(int empresa, int dia, String horarioActual){
        return  horarioRepository.getProximoSalida(empresa,dia,horarioActual);

    }


}
