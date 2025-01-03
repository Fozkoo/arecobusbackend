package com.example.arecobusbackend.Repositories;


import com.example.arecobusbackend.Models.Coodenadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordenadasRepository extends JpaRepository<Coodenadas, Integer> {
}
