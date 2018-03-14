package com.yacht.molvenorestaurant.model;

import lombok.Data;

import java.util.List;

@Data
public class MenuCard {
    private List<Menu> gangenMenu;

    private List<Menu> voorgerecht;

    private List<Menu> hoofdgerecht;

    private List<Menu> nagerecht;

    private List<Menu> warmeDranken;

    private List<Menu> koudeDranken;

    private List<Menu> alcoholisch;

    private List<Menu> nonAlcoholisch;
}
