package net.codejava.services;

import net.codejava.repositories.Customer;
import net.codejava.repositories.CustomerRepository;
import net.codejava.repositories.Location;
import net.codejava.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    LocationRepository repo;


    public List<Location> getAllLocations() {
        return repo.findAll();
    }

    public Location createLocation(Location location) {

        repo.save(location);
        return repo.findByCity(location.getCity());
    }
}
