package com.example.arecobusbackend.Controllers;
import com.example.arecobusbackend.DTO.BusesDTO;
import com.example.arecobusbackend.DTO.horariosDTO;
import com.example.arecobusbackend.Services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;



    /* TRAE LA INFORMACION DE LOS BUSES SIN LOS HORARIOS*/

    @CrossOrigin
    @GetMapping("/getAllBuses")
    public List<BusesDTO> getAllBuses () {
        return busService.getAllBuses();
    }


    /* TRAE TODA INFORMACION DE LOS BUSES (HORARIOS,PATH,IMAGE, ETC)
    * (Este es el que tengo que usar en el home para que me muestre el proximo viaje)
    * */
    @CrossOrigin
    @GetMapping("/getAllBusesInfo")
    public ResponseEntity<List<horariosDTO>> getBusInfoWithHorarios() {
        List<horariosDTO> busInfo = busService.getBusInfoWithHorarios();
        return ResponseEntity.ok(busInfo);
    }


    /* este me trae tambien toda la info pero filtrando por id */

    @CrossOrigin
    @GetMapping("/getBusInfoById/{idbus}")
    public ResponseEntity<List<horariosDTO>> getBusInfoWithHorariosById(@PathVariable Integer idbus) {
        List<horariosDTO> busInfo = busService.getBusInfoWithHorariosById(idbus);
        return ResponseEntity.ok(busInfo);
    }

} 