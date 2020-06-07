package dev.joshpope.Kennels.API.bookings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {

    @Query(value = "SELECT * FROM rooms WHERE id not in " +
            "(SELECT rooms.id FROM rooms INNER JOIN bookings ON rooms.id = bookings.room_id WHERE " +
            "(CAST(?1 AS DATE) > CAST(bookings.start_date AS DATE) AND " +
            "CAST(?1 AS DATE) < CAST(bookings.end_date AS DATE)) OR " +
            "(CAST(?2 AS DATE) > CAST(bookings.start_date AS DATE) AND" +
            " CAST(?2 AS DATE) < CAST(bookings.end_date AS DATE)) OR " +
            "((CAST(bookings.start_date AS DATE) > CAST(?1 AS DATE) AND " +
            "CAST(bookings.start_date AS DATE) < CAST(?2 AS DATE)) AND " +
            "(CAST(bookings.end_date AS DATE) > CAST(?1 AS DATE) AND " +
            "CAST(bookings.end_date AS DATE) < CAST(?2 AS DATE))))" +
            " and id not like 0", nativeQuery = true)
    List<Rooms> findAvailableRoomsOnDates(String startDate, String endDate);
}
