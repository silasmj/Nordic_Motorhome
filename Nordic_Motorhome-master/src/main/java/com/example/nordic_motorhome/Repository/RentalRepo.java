package com.example.nordic_motorhome.Repository;

import com.example.nordic_motorhome.Model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalRepo {
    @Autowired
    JdbcTemplate template;

    public List<Rental> showRental(){
        String sql = "SELECT * FROM rental";
        RowMapper<Rental> rowMapper = new BeanPropertyRowMapper<>(Rental.class);
        return template.query(sql, rowMapper);
    }
}
