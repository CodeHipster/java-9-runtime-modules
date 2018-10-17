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