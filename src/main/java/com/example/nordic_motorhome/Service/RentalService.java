package com.example.nordic_motorhome.Service;

import com.example.nordic_motorhome.Model.Customer;
import com.example.nordic_motorhome.Model.Rental;
import com.example.nordic_motorhome.Repository.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepo rentalRepo;

    public List<Rental> showRental(){
        return rentalRepo.showRental();
    }

    public Rental createRental(Rental r){
        return rentalRepo.createRental(r);
    }
}
