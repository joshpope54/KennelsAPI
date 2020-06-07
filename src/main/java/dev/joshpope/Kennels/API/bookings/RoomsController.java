package dev.joshpope.Kennels.API.bookings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RoomsController {
    @Autowired
    private RoomsRepository roomsRepository;

    @CrossOrigin
    @GetMapping("/rooms/available/{startDate}/{endDate}")
    public List<Rooms> changeStatus(@PathVariable String startDate, @PathVariable String endDate) {
        return roomsRepository.findAvailableRoomsOnDates(startDate, endDate);
    }
}
