package dev.joshpope.Kennels.API.bookingrates;

import dev.joshpope.Kennels.API.animals.PetType;
import dev.joshpope.Kennels.API.bookings.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRatesRepository extends JpaRepository<BookingRates, Long> {
    BookingRates findBookingRatesByPetTypeEquals(int petType);
}