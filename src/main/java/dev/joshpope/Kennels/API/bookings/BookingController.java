package dev.joshpope.Kennels.API.bookings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    //@Autowired
    //private BookingPostRepository bookingPostRepository;
    @GetMapping("/bookings")
    public List<Booking>  getAllAnimals() {
        return  bookingRepository.findAll();
    }

    @PostMapping("/bookings")
    public Booking newCustomer(@RequestBody Booking newBooking) {
        return bookingRepository.save(newBooking);
    }

    @GetMapping("/bookings/id/{id}")
    public Booking getUsersById(@PathVariable(value = "id") Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingException(bookingId));
    }

    @GetMapping("/bookings/today")
    public List<Booking> getTodaysBookings() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todaysDate = dateFormat.format(date);
        List<Booking> insToday = bookingRepository.findBookingByStartDateLike(todaysDate);
        List<Booking> outsToday = bookingRepository.findBookingByEndDateLike(todaysDate);
        ArrayList<Booking> allToday = new ArrayList<>();
        allToday.addAll(insToday);
        allToday.addAll(outsToday);
        return allToday;
    }

    @GetMapping("/bookings/date/{date}")
    public List<Booking> getBookingsByDate(@PathVariable(value = "date") String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date requestedDate = dateFormat.parse(date);
        List<Booking> insToday = bookingRepository.findBookingByStartDateLike(dateFormat.format(requestedDate));
        List<Booking> outsToday = bookingRepository.findBookingByEndDateLike(dateFormat.format(requestedDate));
        ArrayList<Booking> allToday = new ArrayList<>();
        allToday.addAll(insToday);
        allToday.addAll(outsToday);
        return allToday;
    }

    @GetMapping("/bookings/past")
    public List<Booking> getPastBookings() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todaysDate = dateFormat.format(date);
        return bookingRepository.findBookingByEndDateLessThan(todaysDate);
    }

    @GetMapping("/bookings/current")
    public List<Booking> getCurrentBookings() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todaysDate = dateFormat.format(date);
        return bookingRepository.findBookingByStartDateLessThanEqualAndEndDateGreaterThanEqual(todaysDate, todaysDate);
    }
}
