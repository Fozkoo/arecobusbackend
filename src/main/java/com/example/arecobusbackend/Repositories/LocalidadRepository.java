package com.example.arecobusbackend.Repositories;


import com.example.arecobusbackend.Models.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Integer> {


}
