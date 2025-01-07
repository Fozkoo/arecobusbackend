package com.example.arecobusbackend.Services;
import com.example.arecobusbackend.DTO.ParadasCreateDTO;
import com.example.arecobusbackend.DTO.ParadasDTO;
import com.example.arecobusbackend.Models.Paradas;
import com.example.arecobusbackend.Models.Recorrido;
import com.example.arecobusbackend.Repositories.ParadasRepository;
import com.example.arecobusbackend.Repositories.RecorridoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ParadasService {

    @Autowired
    private ParadasRepository paradasRepository;

    @Autowired
    private RecorridoRepository recorridoRepository;

    public ResponseEntity<?> getParadasByRecorrido(int idRecorrido) {
        List<Paradas> paradas = paradasRepository.findByRecorridoId(idRecorrido);

        List<ParadasDTO> paradasDtos = paradas.stream()
                .map(parada -> new ParadasDTO(
                        parada.getIdparadas(),
                        parada.getLogitud(),
                        parada.getLatitud(),
                        parada.getDescripcion(),
                        parada.getUrl(),
                        parada.getRecorridoByRecorridoIdrecorrido().getIdrecorrido()
                ))
                .toList();

        return ResponseEntity.ok(paradasDtos);
    }

    public ParadasDTO crearParada(ParadasCreateDTO paradaCreateDTO) {
        // Verificar si el recorrido existe
        Recorrido recorrido = recorridoRepository.findById(paradaCreateDTO.getIdRecorrido())
                .orElseThrow(() -> new EntityNotFoundException("Recorrido no encontrado"));

        // Crear una nueva parada
        Paradas nuevaParada = new Paradas();
        nuevaParada.setLogitud(paradaCreateDTO.getLongitud());
        nuevaParada.setLatitud(paradaCreateDTO.getLatitud());
        nuevaParada.setDescripcion(paradaCreateDTO.getDescripcion());
        nuevaParada.setUrl(paradaCreateDTO.getUrl());
        nuevaParada.setRecorridoByRecorridoIdrecorrido(recorrido);

        // Guardar la nueva parada en la base de datos
        paradasRepository.save(nuevaParada);

        // Devolver el DTO de la parada creada
        return new ParadasDTO(
                nuevaParada.getIdparadas(),
                nuevaParada.getLogitud(),
                nuevaParada.getLatitud(),
                nuevaParada.getDescripcion(),
                nuevaParada.getUrl(),
                nuevaParada.getRecorridoByRecorridoIdrecorrido().getIdrecorrido()
        );
    }
}