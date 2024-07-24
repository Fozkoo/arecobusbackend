package com.example.arecobusbackend.Services;

import com.example.arecobusbackend.DTO.BusScheduleDTO;
import com.example.arecobusbackend.Repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public List<BusScheduleDTO> getBusSchedules(Long busId, Long dayOfWeekId) {
        return busRepository.findBusSchedulesByBusIdAndDayOfWeek(busId, dayOfWeekId);
    }
}
