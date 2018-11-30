package net.oostdam.food.console.app;

import net.oostdam.food.recipe.CookBook;
import net.oostdam.food.recipe.Recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        String path = getPathInput();

        Path dir1 = Paths.get(path);
        ModuleFinder finder = ModuleFinder.of(dir1);

        ModuleLayer parent = ModuleLayer.boot();

        Configuration cf = parent.configuration().resolveAndBind(finder, ModuleFinder.of(), Set.of("food.complex"));

        ClassLoader scl = ClassLoader.getSystemClassLoader();

        ModuleLayer layer = parent.defineModulesWithOneLoader(cf, scl);

        ServiceLoader<CookBook> loaderWithModule = ServiceLoader.load(layer, CookBook.class);

        printBooks(loaderWithModule);

        printLayerStructure(CookBook.class);

    }

    private static void printBooks(ServiceLoader<CookBook> loader){
        Iterator<CookBook> iterator = loader.iterator();
        System.out.println("Printing Cookbooks");
        while(iterator.hasNext()){
            CookBook cookBook = iterator.next();
            System.out.println("Cookbook: " + cookBook.toString());
            System.out.println("In module: " + cookBook.getClass().getModule());
            System.out.println("In layer: " + cookBook.getClass().getModule().getLayer());
            System.out.println("Module has packages: " + cookBook.getClass().getModule().getPackages());
            Collection<Recipe> recipes = cookBook.getRecipes();

            recipes.forEach(recipe -> System.out.println(" - " + recipe.getName()));
        }
    }

    private static String getPathInput(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter path to .jar: ");
        String path = null;
        try {
            path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("You entered : " + path);
        return path;
    }

    private static void printLayerStructure(Class clazz){
        clazz.getModule().getLayer().parents().stream().forEach(moduleLayer ->
        {
            System.out.println("ModuleLayer1: "+ moduleLayer);
            moduleLayer.parents().stream().forEach(moduleLayer2 ->
            {
                System.out.println("ModuleLayer2: "+ moduleLayer2);
                moduleLayer2.parents().stream().forEach(moduleLayer3 -> System.out.println("ModuleLayer3: "+ moduleLayer));
            });
        });
    }
}