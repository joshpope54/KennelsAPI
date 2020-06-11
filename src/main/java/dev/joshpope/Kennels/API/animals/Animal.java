package dev.joshpope.Kennels.API.animals;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.joshpope.Kennels.API.bookings.Booking;
import dev.joshpope.Kennels.API.breeds.Breed;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "animal_name")
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "breed_id", referencedColumnName = "id",nullable = false)
    private Breed breed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_type", referencedColumnName = "id",nullable = false)
    private PetType petType;

    @Column(name = "gender")
    private String gender;
    @Column(name = "notes")
    private String notes;
    @Column(name = "stored_image_url")
    private String image;
    @Column(name = "food_information")
    private String food;

    @JsonIgnore
    @ManyToMany(mappedBy = "animals")
    private Set<Booking> bookings = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setBreed(Breed breedId) {
        this.breed = breedId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}