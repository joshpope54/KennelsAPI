package dev.joshpope.Kennels.API.bookings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    long countBookingsByRoomIdNotLikeAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndArrivedLike(long room_id, String startDate, String endDate, String arrived);
    long countBookingsByRoomIdNotLikeAndStartDateLike(long roomId, String startDate);
    long countBookingsByRoomIdNotLikeAndEndDateLike(long roomId, String endDate);
    List<Booking> findBookingByStartDateLikeAndStatusNotLike(String startDate, String status);
    List<Booking> findBookingByEndDateLikeAndStatusNotLike(String endDate, String status);
    List<Booking> findBookingByEndDateLessThan(String date);
    List<Booking> findBookingByStartDateLessThanEqualAndEndDateGreaterThanEqualAndArrivedLike(String startDate, String endDate, String arrived);
}