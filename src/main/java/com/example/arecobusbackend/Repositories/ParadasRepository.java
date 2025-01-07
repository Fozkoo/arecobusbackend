package com.example.arecobusbackend.Repositories;

import com.example.arecobusbackend.Models.Paradas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParadasRepository extends JpaRepository<Paradas, Integer> {

    @Query("SELECT p FROM Paradas p WHERE p.recorridoByRecorridoIdrecorrido.idrecorrido = :recorridoId")
    List<Paradas> findByRecorridoId(@Param("recorridoId") Integer recorridoId);

}
