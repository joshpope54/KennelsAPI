package dev.joshpope.Kennels.API.animals;

public class AnimalException extends RuntimeException {
    AnimalException(Long id){
        super("Could not find animal with ID: " + id);
    }
}
