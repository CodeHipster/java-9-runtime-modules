# food app project

## structure

modules:
 - module for listing recipes

## intellij 

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
javac -d ./out/food.console.app ./food.console-app/src/module-info.java ./food.console-app/src/net/oostdam/food/console/app/Main.java ./food.console-app/src/net/oostdam/food/console/app/Recipe.java  ./food.console-app/src/net/oostdam/food/console/app/CookBook.java ./food.console-app/src/net/oostdam/food/console/app/BookOfPancakes.java 

-d specifies the output directory, it must already exist.

#########
## run ##
#########

java --module-path out -m food.console.app/net.oostdam.food.console.app.Main

--module-path specifies the modules directory, so it can resolve modules the application depends on.
The -m option specifies the main module, the value after the slash is the class name of the main class in the module.

#########
## jar ##
#########


jar -f food.app.jar --create -C out/food.console.app .

java --module-path food.app.jar --module food.console.app/net.oostdam.food.console.app.Main


```


1. creating module

todo: explain basics of java9 modules
- extra level of encapsulation
- module-info.java
- compilation

todo: links for more information

branch: https://github.com/CodeHipster/java-9-runtime-modules/tree/exercise1

todo: howto commandline
todo: howto intellij
    - how to setup app