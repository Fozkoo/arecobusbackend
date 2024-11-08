package com.example.arecobusbackend.Services;

import com.example.arecobusbackend.DTO.horariosDTO;
import com.example.arecobusbackend.Models.Empresa;
import com.example.arecobusbackend.Repositories.EmpresaRepository;
import com.example.arecobusbackend.Repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }



}
