package dev.joshpope.Kennels.API.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customers WHERE first_name like CONCAT(?1,'%') or second_name LIKE CONCAT(?2,'%')", nativeQuery = true)
    List<Customer> findCustomerByFirstNameLikeOrLastNameLike(String firstName, String lastName);

}