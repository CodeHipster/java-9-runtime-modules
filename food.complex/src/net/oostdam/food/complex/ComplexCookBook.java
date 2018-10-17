package net.oostdam.food.complex;

import net.oostdam.food.recipe.CookBook;
import net.oostdam.food.recipe.Recipe;

import java.util.ArrayList;
import java.util.Collection;

public class ComplexCookBook implements CookBook {

    private Collection<Recipe> recipes;

    public ComplexCookBook(){
        this.recipes = new ArrayList<>();
        this.recipes.add(new Recipe("Broiled Lobster Tails with Garlic and Chili Butter"));
        this.recipes.add(new Recipe("Roasted Duck and Pork with Lentils"));
        this.recipes.add(new Recipe("Orange Pistachio-Stuffed Grilled Scallops"));
    }

    public Collection<Recipe> getRecipes(){
        return recipes;
    }
}