package dev.joshpope.Kennels.API.animals;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class AnimalNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AnimalException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(AnimalException ex) {
        return ex.getMessage();
    }
}
