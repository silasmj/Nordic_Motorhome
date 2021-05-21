package com.example.nordic_motorhome.Controller;

import com.example.nordic_motorhome.Model.Customer;
import com.example.nordic_motorhome.Model.Motorhome;
import com.example.nordic_motorhome.Model.Rental;
import com.example.nordic_motorhome.Repository.RentalRepo;
import com.example.nordic_motorhome.Service.CustomerService;
import com.example.nordic_motorhome.Service.MotorhomeService;
import com.example.nordic_motorhome.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CustomerService customerService;
    RentalService rentalService;
    MotorhomeService motorhomeService;

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
    @GetMapping("/motorhome")
    public String motorhome (Model model){
        List<Motorhome> motorhomeList = motorhomeService.showMotorhome();
        model.addAttribute("motorhome", motorhomeList);
        return "home/motorhome";
    }
    @GetMapping("/customer")
    public String customer(Model model){
        List<Customer> customerList = customerService.showCustomer();
        model.addAttribute("customer", customerList);
        return "home/customer";
    }

    @GetMapping("/deleteCustomer/{customer_id}")
    public String deleteCustomer(@PathVariable("customer_id") int customer_id){
        boolean deletedCustomer = customerService.deleteCustomer(customer_id);
        if (deletedCustomer){
            return "redirect:/customer";
        }else{
            return "redirect:/customer";
        }
    }

    @GetMapping("/createCustomer")
    public String createCustomer(){
        return "home/createCustomer";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer){
        customerService.createCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/updateCustomer/{customer_id}")
    public String update(@PathVariable("customer_id") int customer_id, Model model){
        model.addAttribute("customer", customerService.findCustomerById(customer_id));
        return "home/updateCustomer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "redirect:/customer";
    }
}
