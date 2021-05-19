package com.example.nordic_motorhome.Controller;

import com.example.nordic_motorhome.Model.Rental;
import com.example.nordic_motorhome.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    RentalService rentalService;

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping ("/rental")
    public String Rental(Model model) {
        List<Rental> rentalList = rentalService.showRental();
        model.addAttribute("rental", rentalList);
        return "home/rental";
    }
}
