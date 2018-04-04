package com.yacht.molvenorestaurant.controller.frontend;

import com.yacht.molvenorestaurant.model.NavItem;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.Arrays;
import java.util.List;


public abstract class AdminController {
    @ModelAttribute("nav")
    public List<NavItem> menus() {
        NavItem orders = new NavItem("Orders", "/admin/orders");
        NavItem dishes = new NavItem("Dishes", "/admin/dishes");
        NavItem ingredients = new NavItem("Ingredients", "/admin/storage");

        return Arrays.asList(orders, dishes, ingredients);
    }
}
