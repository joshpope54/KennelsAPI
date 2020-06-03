package dev.joshpope.Kennels.API.bookings;
import com.google.gson.Gson;
import com.google.gson.InstanceCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private RoomsRepository roomsRepository;

    //@Autowired
    //private BookingPostRepository bookingPostRepository;
    @GetMapping("/bookings")
    public List<Booking>  getAllAnimals() {
        return  bookingRepository.findAll();
    }

    @PostMapping("/bookings")
    public ResponseEntity<Object> newCustomer(@RequestBody Booking newBooking) {
        bookingRepository.save(newBooking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/bookings/count/insouts")
    public ResponseEntity<String> getTotalIns() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todaysDate = dateFormat.format(date);
        long todaysInsCount = bookingRepository.countBookingsByRoomIdNotLikeAndStartDateLike(0, todaysDate);
        long todaysOutsCount = bookingRepository.countBookingsByRoomIdNotLikeAndEndDateLike(0, todaysDate);
        InsOutsCount counter = new InsOutsCount(todaysInsCount, todaysOutsCount);
        Gson gson = new Gson();
        String json = gson.toJson(counter);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>(json, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/bookings/count/total")
    public ResponseEntity<String> getTotalCount() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String todaysDate = dateFormat.format(date);
        long total = bookingRepository.countBookingsByRoomIdNotLikeAndStartDateLessThanEqualAndEndDateGreaterThanEqual(0,todaysDate,todaysDate);
        TotalCount totalCount = new TotalCount(total, roomsRepository.count()-1);
        Gson gson = new Gson();
        String json = gson.toJson(totalCount);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<String>(json, responseHeaders, HttpStatus.CREATED);
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
