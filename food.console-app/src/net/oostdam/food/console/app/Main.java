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
    public static void main(String[] args) throws ClassNotFoundException {

        ServiceLoader<CookBook> loader = ServiceLoader.load(CookBook.class);
        Iterator<CookBook> iterator = loader.iterator();
        while(iterator.hasNext()){
            CookBook cookBook = iterator.next();
            Collection<Recipe> recipes = cookBook.getRecipes();

            recipes.stream().forEach(recipe -> System.out.println(recipe.getName()));
        }

        Path dir1 = Paths.get("/Users/thijs/projects/meetup/food-app/food.complex.jar");
        ModuleFinder finder = ModuleFinder.of(dir1);

        ModuleLayer parent = ModuleLayer.boot();

        Configuration cf = parent.configuration().resolveAndBind(finder, ModuleFinder.of(), Set.of("food.complex"));

        ClassLoader scl = ClassLoader.getSystemClassLoader();

        ModuleLayer layer = parent.defineModulesWithOneLoader(cf, scl);

        //Class<?> c = layer.findLoader("food.complex").loadClass("CookBook");
        loader = ServiceLoader.load(layer, CookBook.class);
        iterator = loader.iterator();
        while(iterator.hasNext()){
            CookBook cookBook = iterator.next();
            Collection<Recipe> recipes = cookBook.getRecipes();

            recipes.stream().forEach(recipe -> System.out.println(recipe.getName()));
        }

    }
}