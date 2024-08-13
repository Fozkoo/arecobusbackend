package com.example.arecobusbackend.DTO;


public interface BusScheduleDTO {
     Long getIdBus();
     String getNumeroLinea();
     String getDestino();
     String getEmpresaNombre();
     String getHorario();
     String getDiaNombre();
}