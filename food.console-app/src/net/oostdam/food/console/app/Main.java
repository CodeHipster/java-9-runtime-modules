package net.oostdam.food.console.app;

import net.oostdam.food.recipe.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        CookBook cookbook = ServiceLoader.load(CookBook.class).iterator().next();

        Collection<Recipe> recipes = cookbook.getRecipes();

        for(Recipe r : recipes){
            System.out.println(r.getName());
        }
    }
}