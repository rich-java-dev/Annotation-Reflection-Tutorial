# Annotation-Reflection-Tutorial
## A basic implementation of a Data Store using Java Spring Framework inspired pattern.

### The purpose of this example code is to demonstrate a novel design pattern using less than 200 lines of code!

### General Structure:
* Annotations are a great tool, and really do behave as an extension of Interfaces:
  * They are used to tag (like zero method interfaces) other parts of code with meta-data.
  * Runtime RetentionPolicy allows Reflection classes to access these tags and handle the actual logic/meaning of the annotation
  * Reflection is at the heart of this pattern design (Its the underlying mechanism that makes Annotations so powerful)
* Dependency Injection allows defining 'template' code which is easily reusable
  * Sometimes Abstract Classes do not give enough flexibility (Cannot behave as Functional Interfaces)
  * We can define a Functional interface external to its 'implementing/called class'
* Store is defined which extends behavior from an AbstractStore
  * This allows for cleanly separating the Data sets to be stored from the Annotation/Reflection methods
  * The Store defines methods which create instances of a template class (not abstract), but allows dependency injection so we can conveniently use lambda expressions in its implementation
* The Store passes its class definition to the AbstractStore (Dependency Injection) in order to get proper reference to the Implementing Class.
  * This can be extended to behave with other AbstractStore implementations
* Store uses a singleton pattern. This is not required but centralizes the Store/any class can access this single instance.
* Wrapper data classes are defined, which gives a common base class (Data), and type for instances.
* The Data is pushed to the Store, and using Reflection assigns the Data to the proper Set/Collection, based on being 'tagged' by the Annotation '@DataSet'
  * This style of coding prevents the requirement to create long if/else blocks to determine how to apply a common class (Data) to the respective Sets of different Data extensions

### Line Count of source files:
  * git ls-files *.java | xargs wc -l
  * 11 src/annote/DataSet.java
  * 29 src/annote/FieldAnnoteProcessor.java
  * 8 src/annote/FieldProcess.java
  * 26 src/core/Driver.java
  * 4 src/data/Data.java
  * 8 src/data/Day.java
  * 12 src/data/Num.java
  * 8 src/data/Str.java
  * 59 src/store/AbstractStore.java
  * 34 src/store/Store.java
  * 199 total




### Output of driver class (if unedited [warning: order may change of elements within a given Set]):

 * strSet:
   * This code example demonstrates how to build custom Data Framworks
   * Some techniques you'll see include: Reflection, Dependency Injection, Annotations, Lambda expressions/functional interfaces

 * numSet:
   * 10.05
   * 1

 * daySet:
 * 11/27/2019
 * 1/1/2000
