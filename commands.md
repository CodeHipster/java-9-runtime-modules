# commands

## compile

### food.app module

javac --module-path out -d ./out/food.console.app ./food.console-app/src/module-info.java ./food.console-app/src/net/oostdam/food/console/app/Main.java

-d specifies the output directory, it must already exist.
--module-path specifies the modules directory, so it can resolve modules the application depends on.

### food.recipe

javac -d ./out/food.recipe ./food.recipe/src/module-info.java ./food.recipe/src/net/oostdam/food/recipe/CookBook.java ./food.recipe/src/net/oostdam/food/recipe/Recipe.java

### food.simple

javac --module-path ./out -d ./out/food.simple ./food.simple/src/module-info.java ./food.simple/src/net/oostdam/food/simple/SimpleCookBook.java

### food.complex

javac --module-path ./out -d ./out/food.complex ./food.complex/src/module-info.java ./food.complex/src/net/oostdam/food/complex/ComplexCookBook.java


## run

### food.app module

java --module-path out -m food.console.app/net.oostdam.food.console.app.Main

The -m option specifies the main module, the value after the slash is the class name of the main class in the module.



jar -f food.complex.jar --create -C out/production/food.complex .
jar -f food.app.jar --create -C out/production/food.console-app .