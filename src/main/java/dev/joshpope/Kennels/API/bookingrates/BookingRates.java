package dev.joshpope.Kennels.API.bookingrates;

import dev.joshpope.Kennels.API.animals.PetType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "boarding_rates")
@EntityListeners(AuditingEntityListener.class)
public class BookingRates {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_type", referencedColumnName = "id",nullable = false)
    private PetType petType;

    @Column(name = "cost_per_night")
    private float cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
