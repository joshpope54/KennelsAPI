package dev.joshpope.Kennels.API.bookingrates;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class RateNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BookingRateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(BookingRateException ex) {
        return ex.getMessage();
    }
}
