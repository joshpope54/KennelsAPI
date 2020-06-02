package dev.joshpope.Kennels.API.bookings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByStartDateLike(String date);
    List<Booking> findBookingByEndDateLike(String date);
    List<Booking> findBookingByEndDateLessThan(String date);
    List<Booking> findBookingByStartDateLessThanEqualAndEndDateGreaterThanEqual(String date, String date2);
}