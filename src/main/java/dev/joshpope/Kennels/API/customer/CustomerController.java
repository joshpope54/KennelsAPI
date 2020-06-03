package dev.joshpope.Kennels.API.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getUsersById(@PathVariable(value = "id") Long userId) {
        return customerRepository.findById(userId)
                .orElseThrow(() -> new CustomerException(userId));
    }

    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }
}
