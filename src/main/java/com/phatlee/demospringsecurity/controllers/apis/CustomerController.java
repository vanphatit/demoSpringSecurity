package com.phatlee.demospringsecurity.controllers.apis;

import com.phatlee.demospringsecurity.models.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity
public class CustomerController {
    final private List<Customer> customers = List.of(
            Customer.builder().id("001").name("Phat")
                    .phoneNumber("123").email("vanphat15it@gmail.com").build(),
            Customer.builder().id("002").name("Lee")
                    .phoneNumber("456").email("22110196@student.hcmute.edu.vn").build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, World!");
    }

    @GetMapping("/api/customers/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list = this.customers;
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/customers/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        List<Customer> customers = this.customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .toList();
        return ResponseEntity.ok(customers.get(0));
    }
}
