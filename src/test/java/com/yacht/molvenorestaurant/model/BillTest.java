package com.yacht.molvenorestaurant.model;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BillTest {


    @InjectMocks
    private Bill bill;

    @Mock
    private List<Order> orderList;

    @Test
    public void testGetTotalPrice() {

        // mock it
        Order order = new Order();

        Dish dish = new Dish();
        dish.setPrice(new BigDecimal("3.5"));

        order.addDish(dish);

        Mockito.when(this.orderList.iterator()).thenReturn(Arrays.asList(order, order, order).iterator());


        // do it
        BigDecimal totalPrice = this.bill.getTotalPrice();


        //verify and test it
        Assert.assertEquals(new BigDecimal("10.5"), totalPrice);

        Mockito.verify(this.orderList, Mockito.times(1)).iterator(); // equivalent to
        Mockito.verify(this.orderList).iterator();
    }
}