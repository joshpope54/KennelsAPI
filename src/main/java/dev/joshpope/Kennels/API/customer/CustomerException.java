package dev.joshpope.Kennels.API.customer;

public class CustomerException extends RuntimeException {
    CustomerException(Long id){
        super("Could not find customer with ID: " + id);
    }
}
