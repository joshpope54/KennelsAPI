package dev.joshpope.Kennels.API.animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetTypesRepository extends JpaRepository<PetType, Long> {
}