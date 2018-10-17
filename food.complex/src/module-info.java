module food.complex {
    requires food.recipe;
    exports net.oostdam.food.complex;
    provides net.oostdam.food.recipe.CookBook
        with net.oostdam.food.complex.ComplexCookBook;
}