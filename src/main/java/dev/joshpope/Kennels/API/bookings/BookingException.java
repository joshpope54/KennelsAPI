package dev.joshpope.Kennels.API.bookings;

public class BookingException extends RuntimeException {
    BookingException(Long id){
        super("Could not find booking with ID: " + id);
    }
}
