package com.example.arecobusbackend.Controllers;

import com.example.arecobusbackend.DTO.BusScheduleDTO;
import com.example.arecobusbackend.Services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/{busId}/schedules/{dayOfWeekId}")
    public List<BusScheduleDTO> getBusSchedules(@PathVariable Long busId, @PathVariable Long dayOfWeekId) {
        return busService.getBusSchedules(busId, dayOfWeekId);
    }
}