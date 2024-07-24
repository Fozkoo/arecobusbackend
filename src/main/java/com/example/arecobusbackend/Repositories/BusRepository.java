package com.example.arecobusbackend.Repositories;

import com.example.arecobusbackend.DTO.BusScheduleDTO;
import com.example.arecobusbackend.Models.Bus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {

    @Query(value = "SELECT b.idbus AS idBus, b.numero_linea AS numeroLinea, b.destino AS destino, e.nombre AS empresaNombre, h.horario AS horario, ds.nombre AS diaNombre " +
            "FROM bus b " +
            "INNER JOIN empresa e ON b.empresa_idempresa = e.idempresa " +
            "INNER JOIN bus_has_horarios bh ON b.idbus = bh.bus_idbus " +
            "INNER JOIN horarios h ON bh.horarios_idhorarios = h.idhorarios " +
            "INNER JOIN dias_semana_has_horarios dsh ON h.idhorarios = dsh.horarios_idhorarios " +
            "INNER JOIN dias_semana ds ON dsh.dias_semana_iddias_semana = ds.iddias_semana " +
            "WHERE b.idbus = :busId AND dsh.dias_semana_iddias_semana = :dayOfWeekId", nativeQuery = true)
    List<BusScheduleDTO> findBusSchedulesByBusIdAndDayOfWeek(@Param("busId") Long busId, @Param("dayOfWeekId") Long dayOfWeekId);
}