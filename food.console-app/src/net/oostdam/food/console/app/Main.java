package net.oostdam.food.console.app;

import net.oostdam.food.recipe.CookBook;
import net.oostdam.food.recipe.Recipe;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<CookBook> loader = ServiceLoader.load(CookBook.class);
        printBooks(loader);

        Path dir1 = Paths.get("/Users/thijs/projects/meetup/food-app/food.complex.jar");
        ModuleFinder finder = ModuleFinder.of(dir1);

        ModuleLayer parent = ModuleLayer.boot();

        Configuration cf = parent.configuration().resolveAndBind(finder, ModuleFinder.of(), Set.of("food.complex"));

        ClassLoader scl = ClassLoader.getSystemClassLoader();

        ModuleLayer layer = parent.defineModulesWithOneLoader(cf, scl);

        ServiceLoader<CookBook> loaderWithModule = ServiceLoader.load(layer, CookBook.class);

        printBooks(loaderWithModule);

    }

    private static void printBooks(ServiceLoader<CookBook> loader){
        Iterator<CookBook> iterator = loader.iterator();
        System.out.println("Printing Cookbooks");
        while(iterator.hasNext()){
            CookBook cookBook = iterator.next();
            System.out.println("Cookbook: " + cookBook.toString());
            Collection<Recipe> recipes = cookBook.getRecipes();

            recipes.stream().forEach(recipe -> System.out.println(" - " + recipe.getName()));
        }
    }
}