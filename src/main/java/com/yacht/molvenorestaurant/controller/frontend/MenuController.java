package com.yacht.molvenorestaurant.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("public/menu")
public class MenuController {

    @GetMapping()
    public String index(Map<String, Object> model){
        return "menu";
    }
}
