# food app project
exercise 1: creating a simple module

branch: https://github.com/CodeHipster/java-9-runtime-modules/tree/exercise1

## structure

modules:
 - module for listing recipes

## intellij 

### import bug

To run this project in intellij you will have to create a project and the modules from scratch
and copy paste the code.

importing modules/projects from existing sources seems to break the Run/Debug configuration for Java9

## command line

### compile food.app module
``` 
javac -d ./out/food.console.app ./food.console-app/src/module-info.java ./food.console-app/src/net/oostdam/food/console/app/Main.java ./food.console-app/src/net/oostdam/food/console/app/Recipe.java  ./food.console-app/src/net/oostdam/food/console/app/CookBook.java ./food.console-app/src/net/oostdam/food/console/app/BookOfPancakes.java 
```

javac
- -d specifies the output directory, it must already exist.

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

java --module-path food.app.jar --module food.console.app
```

jar 
- -f/--file to specify the output file
- -c/--create to create a new archive
- -C specify directory and files to include in archive

java 
- --module-path, specify where to look for the module (can also be an archive)
- -m/--module, specify module to run (and optionally main class, if you did not specify main-class when creating the jar)
    

### extra sources
https://www.oracle.com/corporate/features/understanding-java-9-modules.html
https://docs.oracle.com/javase/9/tools/jar.htm
https://docs.oracle.com/javase/9/tools/java.htm



