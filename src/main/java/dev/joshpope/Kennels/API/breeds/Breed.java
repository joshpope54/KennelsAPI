package dev.joshpope.Kennels.API.breeds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "breeds")
@EntityListeners(AuditingEntityListener.class)
public class Breed {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "breed_name")
    private String breedName;

    @ManyToOne
    private Species species;

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public long getId() {
        return id;
    }

    public void setId(long breedID) {
        this.id = breedID;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}