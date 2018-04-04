package com.yacht.molvenorestaurant.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/orders")
public class OrderScreenController extends AdminController {

    @GetMapping()
    public String index() {
        return "orderscreen";
    }
}
