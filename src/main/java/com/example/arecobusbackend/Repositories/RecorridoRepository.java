package com.example.arecobusbackend.Repositories;

import com.example.arecobusbackend.Models.Recorrido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecorridoRepository extends JpaRepository<Recorrido, Integer> {
}
