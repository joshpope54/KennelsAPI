package dev.joshpope.Kennels.API.bookingrates;

public class BookingRateException extends RuntimeException {
    BookingRateException(Long id){
        super("Could not find rate with ID: " + id);
    }
}
