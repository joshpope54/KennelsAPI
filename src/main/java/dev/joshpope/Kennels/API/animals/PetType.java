package dev.joshpope.Kennels.API.animals;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.joshpope.Kennels.API.bookings.Booking;
import dev.joshpope.Kennels.API.breeds.Breed;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pets_types")
@EntityListeners(AuditingEntityListener.class)
public class PetType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "type")
    private String typeName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}