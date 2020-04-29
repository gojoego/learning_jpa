package net.codejava.services;

import net.codejava.repositories.Customer;
import net.codejava.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repo;


    public List<Customer> getAllCustomers() {
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Customer createCustomer(Customer customer) {

        repo.save(customer);
        return repo.findByFirstnameAndLastname(customer.getFirstname(), customer.getLastname());
    }

    public void deleteCustomer (long id){
        repo.deleteById(id);

    }

    public Customer getCustomerById (long id){
        return repo.findById(id).get();
    }

}
