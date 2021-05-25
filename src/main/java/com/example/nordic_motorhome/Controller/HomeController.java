package com.example.nordic_motorhome.Controller;

import com.example.nordic_motorhome.Model.Customer;
import com.example.nordic_motorhome.Model.Motorhome;
import com.example.nordic_motorhome.Model.Rental;
import com.example.nordic_motorhome.Repository.MotorhomeRepo;
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
    @Autowired
    RentalService rentalService;
    @Autowired
    MotorhomeService motorhomeService;

    @GetMapping("/")
    public String index() {
        return "home/index";
    }
   /* @PostMapping("/")
    public String createRentalIndex(@ModelAttribute Rental rental){
        rentalService.createRental(rental);
        return "redirect:/customer";
    } */

    @GetMapping ("/rental")
    public String Rental(Model model) {
        List<Rental> rentalList = rentalService.showRental();
        model.addAttribute("rental", rentalList);
        return "home/rental";
    }

    @GetMapping("/createRental")
    public String createRental(){
        return "home/createRental";
    }

    @PostMapping("/createRental")
    public String createRental(@ModelAttribute Rental rental){
        rentalService.createRental(rental);
        return "home/succesRental";
    }


    @GetMapping("/motorhome")
    public String motorhome (Model model){
        List<Motorhome> motorhomeList = motorhomeService.showMotorhome();
        model.addAttribute("motorhome", motorhomeList);
        return "home/motorhome";
    }

    @GetMapping("/createMotorhome")
    public String createMotorhome(){
        return "home/createMotorhome";
    }

    @PostMapping("/createMotorhome")
    public String createMotorhome(@ModelAttribute Motorhome motorhome){
        motorhomeService.createMotorhome(motorhome);
        return "home/succesMotorhome";

    }
    @GetMapping("/deleteMotorhome/{motorhome_id}")
    public String deleteMotorhome(@PathVariable("motorhome_id") int motorhome_id){
        boolean deletedMotorhome = motorhomeService.deleteMotorhome(motorhome_id);
        if (deletedMotorhome){
            return "redirect:/motorhome";
        }else{
            return "redirect:/motorhome";
        }
    }
    @GetMapping("/updateMotorhome/{motorhome_id}")
    public String updateMH(@PathVariable("motorhome_id") int motorhome_id, Model model){
        model.addAttribute("motorhome", motorhomeService.findMotorhomeById(motorhome_id));
        return "home/updateMotorhome";
    }
    @PostMapping("/updateMotorhome")
    public String updateMotorhome(@ModelAttribute Motorhome motorhome){
        motorhomeService.updateMotorhome(motorhome.getMotorhome_id(), motorhome);
        return "home/editedMotorhome";
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
        return "home/succesCustomer";
    }

    @GetMapping("/updateCustomer/{customer_id}")
    public String update(@PathVariable("customer_id") int customer_id, Model model){
        model.addAttribute("customer", customerService.findCustomerById(customer_id));
        return "home/updateCustomer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "home/editedCustomer";
    }
}
