package com.example.arecobusbackend.Repositories;

import com.example.arecobusbackend.Models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    /*
    @Query(value = "SELECT b.idbus, b.numero_linea, b.destino, e.nombre AS empresa_nombre, h.horario, ds.nombre AS dia_nombre " +
            "FROM bus b " +
            "JOIN empresa e ON b.empresa_idempresa = e.idempresa " +
            "JOIN bus_has_horarios bh ON b.idbus = bh.bus_idbus " +
            "JOIN horarios h ON bh.horarios_idhorarios = h.idhorarios " +
            "JOIN dias_semana_has_horarios dsh ON h.idhorarios = dsh.horarios_idhorarios " +
            "JOIN dias_semana ds ON dsh.dias_semana_iddias_semana = ds.iddias_semana " nativeQuery = true);

    public List<Horario> findByEmpresaId(int id);


     */

}
