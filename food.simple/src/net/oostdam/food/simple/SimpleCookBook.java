package net.oostdam.food.simple;

import net.oostdam.food.recipe.CookBook;
import net.oostdam.food.recipe.Recipe;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleCookBook implements CookBook {

    private Collection<Recipe> recipes;

    public SimpleCookBook(){
        this.recipes = new ArrayList<>();
        this.recipes.add(new Recipe("bacon & eggs"));
        this.recipes.add(new Recipe("pancakes"));
    }

    public Collection<Recipe> getRecipes(){
        return recipes;
    }
}