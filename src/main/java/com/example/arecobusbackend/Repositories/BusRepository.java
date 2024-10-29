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

    /* Consulta original de Gustavo modificada para incluir origen */

    @Query(value = "SELECT b.idbus AS idBus, b.numero_linea AS numeroLinea, b.destino AS destino, e.nombre AS empresaNombre, h.horario AS horario, ds.nombre AS diaNombre, b.origen AS origen " +
            "FROM bus b " +
            "INNER JOIN empresa e ON b.empresa_idempresa = e.idempresa " +
            "INNER JOIN bus_has_horarios bh ON b.idbus = bh.bus_idbus " +
            "INNER JOIN horarios h ON bh.horarios_idhorarios = h.idhorarios " +
            "INNER JOIN dias_semana_has_horarios dsh ON h.idhorarios = dsh.horarios_idhorarios " +
            "INNER JOIN dias_semana ds ON dsh.dias_semana_iddias_semana = ds.iddias_semana " +
            "WHERE b.idbus = :busId AND dsh.dias_semana_iddias_semana = :dayOfWeekId", nativeQuery = true)
    List<BusScheduleDTO> findBusSchedulesByBusIdAndDayOfWeek(@Param("busId") Long busId, @Param("dayOfWeekId") Long dayOfWeekId);


    /* Consulta para traer todos los buses con el campo origen */

    @Query(value = "SELECT " +
            "    b.idbus, " +
            "    b.numero_linea, " +
            "    b.destino, " +
            "    b.punto_partida, " +
            "    e.nombre AS empresa_nombre, " +
            "    b.precio, " +
            "    b.image, " +
            "    b.path, " +
            "    b.origen, " +  // Agregada esta línea
            "    GROUP_CONCAT(h.horario ORDER BY h.horario ASC SEPARATOR ', ') AS horarios " +
            "FROM " +
            "    bus b " +
            "JOIN " +
            "    empresa e ON b.empresa_idempresa = e.idempresa " +
            "JOIN " +
            "    bus_has_horarios bh ON b.idbus = bh.bus_idbus " +
            "JOIN " +
            "    horarios h ON bh.horarios_idhorarios = h.idhorarios " +
            "GROUP BY " +
            "    b.idbus, b.numero_linea, b.destino, b.punto_partida, e.nombre, b.precio, b.image, b.path, b.origen",
            nativeQuery = true)
    List<Object[]> getBusInfoWithHorarios();


    /* Consulta para filtrar por el ID del día e incluir origen */

    @Query(value = "SELECT b.idbus, b.numero_linea, b.destino, b.punto_partida, " +
            "e.nombre AS empresa_nombre, b.precio, b.image, b.path, b.origen, " +  // Agregada esta línea
            "GROUP_CONCAT(h.horario ORDER BY h.horario ASC SEPARATOR ', ') AS horarios " +
            "FROM empresa e " +
            "INNER JOIN bus b ON e.idempresa = b.empresa_idempresa " +
            "INNER JOIN bus_has_horarios bu ON b.idbus = bu.bus_idbus " +
            "INNER JOIN horarios h ON bu.horarios_idhorarios = h.idhorarios " +
            "INNER JOIN dias_semana_has_horarios dh ON dh.horarios_idhorarios = h.idhorarios " +
            "INNER JOIN dias_semana d ON dh.dias_semana_iddias_semana = d.iddias_semana " +
            "WHERE d.iddias_semana = :iddia " +
            "GROUP BY b.idbus, b.numero_linea, b.destino, b.punto_partida, e.nombre, b.precio, b.image, b.path, b.origen", // Modificación aquí
            nativeQuery = true)
    List<Object[]> getBusInfoConIdDia(@Param("iddia") Integer idbus);


    /* Consulta para filtrar por el ID del bus e incluir origen */

    @Query(value = "SELECT " +
            "    b.idbus, " +
            "    b.numero_linea, " +
            "    b.destino, " +
            "    b.punto_partida, " +
            "    e.nombre AS empresa_nombre, " +
            "    b.precio, " +
            "    b.image, " +
            "    b.path, " +
            "    b.origen, " +  // Agregada esta línea
            "    GROUP_CONCAT(h.horario ORDER BY h.horario ASC SEPARATOR ', ') AS horarios " +
            "FROM " +
            "    bus b " +
            "JOIN " +
            "    empresa e ON b.empresa_idempresa = e.idempresa " +
            "JOIN " +
            "    bus_has_horarios bh ON b.idbus = bh.bus_idbus " +
            "JOIN " +
            "    horarios h ON bh.horarios_idhorarios = h.idhorarios " +
            "WHERE " +
            "    b.idbus = :idbus " +
            "GROUP BY " +
            "    b.idbus, b.numero_linea, b.destino, b.punto_partida, e.nombre, b.precio, b.image, b.path, b.origen", // Modificación aquí
            nativeQuery = true)
    List<Object[]> getBusInfoWithHorariosById(@Param("idbus") Integer idbus);

}
