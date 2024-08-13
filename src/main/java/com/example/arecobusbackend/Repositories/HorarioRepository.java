package com.example.arecobusbackend.Repositories;

import com.example.arecobusbackend.Models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    @Query(value = "SELECT h.* FROM horarios h " +
            "INNER JOIN dias_semana_has_horarios dh ON dh.horarios_idhorarios = h.idhorarios " +
            "INNER JOIN dias_semana d ON dh.dias_semana_iddias_semana = d.iddias_semana " +
            "INNER JOIN bus_has_horarios bs ON h.idhorarios = bs.horarios_idhorarios " +
            "INNER JOIN bus b ON bs.bus_idbus = b.idbus " +
            "WHERE b.idbus = :idBus AND d.iddias_semana = :idDiasSemana AND h.horario > :horario " +
            "ORDER BY h.horario ASC " +
            "LIMIT 1", nativeQuery = true)
    List<Horario> getProximoSalida(@Param("idBus") int idBus,
                                   @Param("idDiasSemana") int idDiasSemana,
                                   @Param("horario") String horario);



    /* CONSULTA LOS HORARIOS DEL DIA Y BUS DESEADO */

    @Query(value = "SELECT b.idbus, " +
            "       b.numero_linea, " +
            "       b.destino, " +
            "       e.nombre AS empresa_nombre, " +
            "       h.horario, " +
            "       ds.nombre AS dia_nombre " +
            "FROM bus b " +
            "JOIN empresa e ON b.empresa_idempresa = e.idempresa " +
            "JOIN bus_has_horarios bh ON b.idbus = bh.bus_idbus " +
            "JOIN horarios h ON bh.horarios_idhorarios = h.idhorarios " +
            "JOIN dias_semana_has_horarios dsh ON h.idhorarios = dsh.horarios_idhorarios " +
            "JOIN dias_semana ds ON dsh.dias_semana_iddias_semana = ds.iddias_semana " +
            "WHERE b.idbus = :idbus " +
            "AND ds.iddias_semana = :diaSemana",
            nativeQuery = true)
    List<Object[]> findBusDetailsWithDay(@Param("idbus") int idbus, @Param("diaSemana") int diaSemana);
}





