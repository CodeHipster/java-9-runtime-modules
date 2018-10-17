package net.oostdam.food.console.app;

import net.oostdam.food.recipe.CookBook;
import net.oostdam.food.recipe.Recipe;

import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<CookBook> loader = ServiceLoader.load(CookBook.class);
        Iterator<CookBook> iterator = loader.iterator();
        while(iterator.hasNext()){
            CookBook cookBook = iterator.next();
            Collection<Recipe> recipes = cookBook.getRecipes();

            recipes.stream().forEach(recipe -> System.out.println(recipe.getName()));
        }

//
//        ServiceLoader.load(CookBook.class).stream().forEach(cookBookProvider -> {
//
//            CookBook cookBook = cookBookProvider.get();
//            Collection<Recipe> recipes = cookBook.getRecipes();
//
//            recipes.stream().forEach(recipe -> System.out.println(recipe.getName()));
//
//        });

    }
}