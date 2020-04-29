package net.codejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

// pretty much the replacement for mapper class
// called repository

public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findByCity(String city);

}
