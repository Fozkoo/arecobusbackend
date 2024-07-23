package com.example.arecobusbackend.Repositories;

import com.example.arecobusbackend.Models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
