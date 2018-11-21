# food app project

## structure

modules:
 - module for listing recipes
    - has a compile time dependency on the recipe interface
    - has runtime dependencies on modules containing recipies
 - module for containing recipes
    - has a compile time dependency on recipe interface
 - module defining recipe interface


## intellij 

###

Module dependencies will have to be manually configured in Open Module Settings -> Dependencies

### import bug

To run this project in intellij you will have to create a project and the modules from scratch
and copy paste the code.

importing modules/projects from existing sources seems to break the Run/Debug configuration for Java9


## command line

### compile 
food.recipe
``` 
javac -d ./out/food.recipe ./food.recipe/src/module-info.java ./food.recipe/src/net/oostdam/food/recipe/CookBook.java ./food.recipe/src/net/oostdam/food/recipe/Recipe.java
``` 

food.app module
``` 
javac --module-path out -d ./out/food.console.app ./food.console-app/src/module-info.java ./food.console-app/src/net/oostdam/food/console/app/Main.java 
```

food.simple
``` 
javac --module-path ./out -d ./out/food.simple ./food.simple/src/module-info.java ./food.simple/src/net/oostdam/food/simple/SimpleCookBook.java
``` 

javac
- -d specifies the output directory, it must already exist.
- --module-path specifies the modules directory, so it can resolve modules the application depends on.

### run
```
java --module-path out --module food.console.app/net.oostdam.food.console.app.Main
```

java
- --module-path specifies the modules directory, so it can resolve modules the application depends on.
- -m/--module option specifies the main module, the value after the slash is the class name of the main class in the module.

### jar
```
jar --file food.app.jar --create --main-class net.oostdam.food.console.app.Main -C out/food.console.app .
jar --file food.recipe.jar --create -C out/food.recipe .
jar --file food.simple.jar --create -C out/food.simple .

TODO: add jlink to path
export PATH="$JAVA_HOME/bin:$PATH"
jlink --module-path $JAVA_HOME/jmods:./out --add-modules food.recipe food.simple food.console.app --output testapp


```

jar 
- -f/--file to specify the output file
- -c/--create to create a new archive
- --main-class, specify the entry point for executable jar
- -C specify directory and files to include in archive

java 
- jar, specify a jar you want to run, only works when the main-class is specified when creating the jar
    

### extra sources
https://www.oracle.com/corporate/features/understanding-java-9-modules.html
https://docs.oracle.com/javase/9/tools/jar.htm
https://docs.oracle.com/javase/9/tools/java.htm
https://docs.oracle.com/javase/9/tools/jlink.htm
https://sites.google.com/a/athaydes.com/renato-athaydes/posts/guidetojava9-compilejarrun
https://steveperkins.com/using-java-9-modularization-to-ship-zero-dependency-native-apps/
https://www.baeldung.com/java-9-modularity


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


TODO: 
console-app:
compile time dependency on recipe
runtime dependency on simple recipies

food.simple
compile time dependency on recipe