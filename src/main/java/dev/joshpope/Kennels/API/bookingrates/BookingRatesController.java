package dev.joshpope.Kennels.API.bookingrates;


import dev.joshpope.Kennels.API.animals.Animal;
import dev.joshpope.Kennels.API.animals.AnimalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingRatesController {
    @Autowired
    private BookingRatesRepository ratesRepository;

    @GetMapping("/rates")
    public List<BookingRates> getAllRates() {
        return ratesRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/rates/{id}")
    public BookingRates getUsersById(@PathVariable(value = "id") int userId) {
        return ratesRepository.findBookingRatesByPetTypeId(userId);
    }
}
