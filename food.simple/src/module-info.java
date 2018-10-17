module food.simple {
    requires food.recipe;
    exports net.oostdam.food.simple;
    provides net.oostdam.food.recipe.CookBook
        with net.oostdam.food.simple.SimpleCookBook;
}