package com.example.nordic_motorhome.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReturnRepo {
    @Autowired
    JdbcTemplate template;

    /*public List<Return> showReturn(){
        String sql = "SELECT * FROM return";
    }*/
}
