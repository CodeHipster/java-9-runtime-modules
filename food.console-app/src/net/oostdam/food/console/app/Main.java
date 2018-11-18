package net.oostdam.food.console.app;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        CookBook cookBook = new BookOfPancakes();
        Collection<Recipe> recipes = cookBook.getRecipes();

        recipes.forEach(recipe -> System.out.println(recipe.getName()));
    }
}