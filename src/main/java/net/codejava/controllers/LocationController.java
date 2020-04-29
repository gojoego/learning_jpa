package net.codejava.controllers;

import net.codejava.repositories.Location;
import net.codejava.repositories.Product;
import net.codejava.services.LocationService;
import net.codejava.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService service;

    @RequestMapping()
    public String addLocation(Model model){
        Location location = new Location();
        model.addAttribute("location", location);

        return "new_location";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLocation(@ModelAttribute("location") Location location) {
        service.createLocation(location);
        return "redirect:/";
    }

//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditLocationPage(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("edit_location");
//        Product product = service.getAllLocations(location);
//        mav.addObject("product", product);
//
//        return mav;
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable(name = "id") int id) {
//        service.delete(id);
//        return "redirect:/";
//    }

}
