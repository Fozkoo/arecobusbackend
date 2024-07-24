package com.example.arecobusbackend.Repositories;

import com.example.arecobusbackend.Models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BusRepositoryE extends CrudRepository<Bus, Integer> {
}
