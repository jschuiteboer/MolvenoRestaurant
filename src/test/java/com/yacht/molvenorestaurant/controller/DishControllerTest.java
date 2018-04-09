package com.yacht.molvenorestaurant.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yacht.molvenorestaurant.business.DishManager;
import com.yacht.molvenorestaurant.model.Dish;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DishControllerTest {

    @InjectMocks
    private DishController dishController;

    @Mock
    private DishManager dishManager;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.dishController).build();
    }

    @Test
    public void addDishTest() throws Exception {
        Dish dish = new Dish();
        dish.setName("Barbeque");
        dish.setDescription("Barbeque met veel (vrucht) vlees");
        dish.setPrice(new BigDecimal("35.0"));
        dish.setId(3L);

        Mockito.when(this.dishManager.saveDish(any(Dish.class))).thenReturn(dish);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(dish);

        this.mockMvc.perform(post("/api/dishes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)).andDo(print())
                .andExpect(jsonPath("$.id", is(Long.valueOf(dish.getId()).intValue())))
                .andExpect(jsonPath("$.name", is(dish.getName())))
                .andExpect(jsonPath("$.description", is(dish.getDescription())))
                .andExpect(jsonPath("$.price", is(dish.getPrice().doubleValue())))
                .andExpect(status().isOk()
                );
    }

}
