package net.oostdam.food.console.app;

import java.util.Arrays;
import java.util.Collection;

public class BookOfPancakes implements CookBook {

    Collection<Recipe> recipes;

    public BookOfPancakes(){
        recipes = Arrays.asList(
                new Recipe("Natural"),
                new Recipe("Blueberry & honey"));
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return recipes;
    }
}
