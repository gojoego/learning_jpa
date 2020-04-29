package net.codejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


// can also extend CRUD repo
// CRUD repo has all go to style queries
// pretty much replaces the mappers
// JPA similar to CRUD
// if methods don't exist that we want, can create them here

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstnameAndLastname(String firstname, String lastname);
}

// repositories extend JPA or CRUD repository