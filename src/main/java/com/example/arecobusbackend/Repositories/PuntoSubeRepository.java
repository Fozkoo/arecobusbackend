package com.example.arecobusbackend.Repositories;

import com.example.arecobusbackend.Models.Puntosube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntoSubeRepository extends JpaRepository<Puntosube, Integer> {

}
