package com.hwq.order.server.controller;

import com.hwq.order.server.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print(){
        return "Name:" + girlConfig.getName() + "," + "Age:" + girlConfig.getAge();
    }
}
