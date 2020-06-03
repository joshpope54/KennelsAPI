package dev.joshpope.Kennels.API.animals;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.joshpope.Kennels.API.bookings.Booking;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "animals")
@EntityListeners(AuditingEntityListener.class)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "animal_name")
    private String name;
    @Column(name = "breed_id")
    private int breedId;
    @Column(name = "gender")
    private String gender;
    @Column(name = "notes")
    private String notes;
    @Column(name = "stored_image_url")
    private String image;
    @Column(name = "food_information")
    private String food;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnore
    private Set<Booking> booking;

    public Set<Booking> getBooking() {
        return booking;
    }

    public void setBooking(Set<Booking> booking) {
        this.booking = booking;
    }

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

    public int getBreedId() {
        return breedId;
    }

    public void setBreedId(int breedId) {
        this.breedId = breedId;
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