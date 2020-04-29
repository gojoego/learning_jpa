package net.codejava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationWebController {
    @GetMapping(value="/location")
    public String homepage(){
        return "carousel_location";
    }
}
