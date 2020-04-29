package net.codejava.controllers;

import net.codejava.repositories.Customer;
import net.codejava.repositories.Product;
import net.codejava.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// API/endpoint

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // @Autowired
    @Autowired
    CustomerService service;

    @RequestMapping()
    public String viewCustomerPage (Model model){
        List<Customer> listCustomers = service.getAllCustomers();
        model.addAttribute("listCustomers", listCustomers);
        return "src/main/resources/templates/customer/default_customer.html";
    }

    @RequestMapping("/new")
    public String showNewCustomerPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "new_customer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        service.createCustomer(customer);

        return "redirect:/customer";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_customer.html");
        Customer customer = service.getCustomerById(id);
        mav.addObject("customer", customer);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(name = "id") int id){
        service.deleteCustomer(id);
        return "redirect:/customer";
    }

}

// finish
// list, create, edit customers exactly like Products (localhost:8080/product)