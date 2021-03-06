package com.luandinh;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {

    @Test
    public void canBrewEspresso() {

        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // when
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // then
        // confirm espresso, no milk, contains enough coffee
        Assert.assertEquals(CoffeeType.Espresso, coffee.getType());
        Assert.assertEquals(0, coffee.getMilk());
        Assert.assertEquals(7, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans() {

        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // when
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // then
        Assert.assertEquals(0, cafe.getBeansInStock());

    }

    //@Test(expected = IllegalStateException.class)
    @Test
    public void lattesRequiresMilk() {

        // given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // when
        cafe.brew(CoffeeType.Latte);

    }
}
