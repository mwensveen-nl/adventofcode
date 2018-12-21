package nl.mwensveen.adventofcode.year_2018.day_14;

import org.junit.Assert;
import org.junit.Test;

public class RecipeProductionTest {

    @Test
    public void testProducePartOne9() throws Exception {
        RecipeProduction recipeProduction = new RecipeProduction("9");
        Assert.assertEquals("5158916779", recipeProduction.producePartOne());
    }

    @Test
    public void testProducePartOne5() throws Exception {
        RecipeProduction recipeProduction = new RecipeProduction("5");
        Assert.assertEquals("0124515891", recipeProduction.producePartOne());
    }

    @Test
    public void testProducePartOne18() throws Exception {
        RecipeProduction recipeProduction = new RecipeProduction("18");
        Assert.assertEquals("9251071085", recipeProduction.producePartOne());
    }

    @Test
    public void testProducePartOne2018() throws Exception {
        RecipeProduction recipeProduction = new RecipeProduction("2018");
        Assert.assertEquals("5941429882", recipeProduction.producePartOne());
    }

    @Test
    public void testProducePartTwo51589() throws Exception {
        RecipeProduction recipeProduction = new RecipeProduction("51589");
        Assert.assertEquals(9, recipeProduction.producePartTwo());
    }

    @Test
    public void testProducePartTwo01245() throws Exception {
        RecipeProduction recipeProduction = new RecipeProduction("01245");
        Assert.assertEquals(5, recipeProduction.producePartTwo());
    }

    @Test
    public void testProducePartTwo92510() throws Exception {
        RecipeProduction recipeProduction = new RecipeProduction("92510");
        Assert.assertEquals(18, recipeProduction.producePartTwo());
    }

    @Test
    public void testProducePartTwo59414() throws Exception {
        RecipeProduction recipeProduction = new RecipeProduction("59414");
        Assert.assertEquals(2018, recipeProduction.producePartTwo());
    }

}
