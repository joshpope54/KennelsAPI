package dev.joshpope.Kennels.API.bookings;

import dev.joshpope.Kennels.API.animals.Animal;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "customer_id")
    private int customerId;
    @ManyToOne
    private Rooms room;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdTimestamp;
    @Column(name = "status")
    private String status;
    @Column(name = "payment_total")
    private float paymentTotal;
    @Column(name = "type")
    private String type;
    @Column(name = "arrived_status")
    private String arrived;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "bookings_animals",
            joinColumns = { @JoinColumn(name = "booking_id") },
            inverseJoinColumns = { @JoinColumn(name = "animals_id") }
    )
    Set<Animal> animals = new HashSet<>();

    public Set<Animal> getAnimals() {
        return animals;
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

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(float paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArrived() {
        return arrived;
    }

    public void setArrived(String arrived) {
        this.arrived = arrived;
    }
}