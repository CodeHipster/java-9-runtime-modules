# food app project

## structure

modules:
 - module for listing recipes(food.console.app)
    - has a compile time dependency on the recipe interface
    - has runtime dependencies on modules containing recipies
 - module defining recipe interface(food.recipe)
 - module for containing simple recipes(food.simple)
    - has a compile time dependency on recipe interface
 - module for containing complex recipes(food.complex)
    - has a compile time dependency on recipe interface


## intellij 

###

Module dependencies will have to be manually configured in Open Module Settings -> Dependencies

### import bug

To run this project in intellij you will have to create a project and the modules from scratch
and copy paste the code.

importing modules/projects from existing sources seems to break the Run/Debug configuration for Java9


## command line

``` 
###########
# compile #
###########

###################
# food.app module #
###################
javac --module-path out -d ./out/food.console.app ./food.console-app/src/module-info.java ./food.console-app/src/net/oostdam/food/console/app/Main.java

-d specifies the output directory, it must already exist.
--module-path specifies the modules directory, so it can resolve modules the application depends on.

###############
# food.recipe #
###############
javac -d ./out/food.recipe ./food.recipe/src/module-info.java ./food.recipe/src/net/oostdam/food/recipe/CookBook.java ./food.recipe/src/net/oostdam/food/recipe/Recipe.java

###############
# food.simple #
###############
javac --module-path ./out -d ./out/food.simple ./food.simple/src/module-info.java ./food.simple/src/net/oostdam/food/simple/SimpleCookBook.java

################
# food.complex #
################
javac --module-path ./out -d ./out/food.complex ./food.complex/src/module-info.java ./food.complex/src/net/oostdam/food/complex/ComplexCookBook.java

#########
## run ##
#########

###################
# food.app module #
###################

java --module-path out -m food.console.app/net.oostdam.food.console.app.Main

The -m option specifies the main module, the value after the slash is the class name of the main class in the module.

```