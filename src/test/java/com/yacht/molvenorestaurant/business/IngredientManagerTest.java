package com.yacht.molvenorestaurant.business;

import com.yacht.molvenorestaurant.model.Ingredient;
import com.yacht.molvenorestaurant.repository.IIngredientRepository;

import org.easymock.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

@RunWith(EasyMockRunner.class)
public class IngredientManagerTest extends EasyMockSupport {


    @TestSubject
    private IngredientManager ingredientManager = new IngredientManager();

    @Mock
    private IIngredientRepository ingredientRepository;

    Ingredient ingredient = new Ingredient(
            "kaas",3,4,new BigDecimal(3.50),null,"plakken",null
    );

    @Before
    public void setup(){
        ingredientRepository = createNiceMock(IIngredientRepository.class);
    }

    @Test
    public void isOutOfStock() {
        Assert.assertEquals(ingredientManager.isOutOfStock(ingredient),false);
    }

    @Test
    public void getAll() {
        EasyMock.expect(ingredientRepository.findAll()).andReturn(null);
        EasyMock.replay(ingredientRepository);

        Assert.assertEquals(ingredientManager.getAll(), null);
    }

    @Test
    public void getOne() {
        EasyMock.expect(ingredientRepository.findOne(1L)).andReturn(null);
        EasyMock.replay(ingredientRepository);

        Assert.assertEquals(ingredientManager.getOne(1L), null);
    }

    @Test
    public void saveIngredient() {
        EasyMock.expect(ingredientRepository.save(ingredient)).andReturn(null);
        EasyMock.replay(ingredientRepository);

        Assert.assertEquals(ingredientManager.saveIngredient(ingredient), null);
    }

    @Test
    public void deleteIngredient() {
        ingredientRepository.delete(1L);

        EasyMock.expectLastCall().andAnswer(new IAnswer<Object>() {
            public Object answer() {
                // do additional assertions here
                IngredientManager arg1 = (IngredientManager) EasyMock.getCurrentArguments()[0];

                // return null because of void
                return null;
            }
        });

        Assert.assertEquals(ingredientManager.getAll(), null);
    }
}