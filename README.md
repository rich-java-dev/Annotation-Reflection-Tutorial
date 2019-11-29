# Annotation-Reflection-Tutorial
## A basic implementation of a Data Store using a custom Annotation API template

### This code is extensible/provides a easy-to-use API to use to implement all sorts of Annotations: Go Build your own Java frame-work!

### Structure:
* annote Package:
  * AnnoteProcessor provides 2 static methods for applying 'behavior' of Annotations to implementing classes:
  * DataSet is the implemented Annotation used in these examples
  * FieldProcess/MethodProcess are functional interfaces injected into the AnnoteProcessor methods, defined in an external implementing class
 
* store Package:
  * AbstractStore defines basic implementations of the DataSet annotation using reflection.
  * Uses dependency injection to get reference of the AbstractStore's specific implementation, giving access to the underlying class
  * Extensible enough to work with a variety of different Store implementations (Singleton vs. instance Stores for example)
  * Store is the basic implementation for this tutorial, using a singleton pattern design.

* core Package:
  * Contains the driver of the program, and basic usage of the overall structure of the implementation

### Additional Comments:
* Annotations are a great tool, and behave as an extension of Interfaces:
  * They are used to tag (like zero method interfaces) other parts of code with meta-data.
  * Runtime RetentionPolicy allows Reflection classes to access these tags and handle the actual logic/meaning of the annotation
  * Annotations can define method signatures (like interfaces), which can behave like parameters at run-time, for instance to conditional logic
  * Reflection is at the heart of this pattern design (Its the underlying mechanism that makes Annotations so powerful)
* Dependency Injection allows defining 'template' code which is easily reusable
  * Sometimes Abstract Classes do not give enough flexibility (Cannot behave as Functional Interfaces)
  * We can define a Functional interface external to its 'implementing/called class'
* Store is defined which extends behavior from an AbstractStore
  * This allows for cleanly separating the Data sets to be stored from the Annotation/Reflection methods
  * The AbstractStore defines methods on how to push, print, and clear data for its implementing classes.
  * The Store passes its class definition to the AbstractStore (Dependency Injection) so the implementing Class.
  * This can be extended to behave with other AbstractStore implementations
* Store uses a singleton pattern. This is not required but centralizes the Store/any class can access this single instance.
* The Data is pushed to the Store, and using Reflection assigns the Data/Object to the proper Set/Collection, based on being 'tagged' by the Annotation '@DataSet'
  * This style of coding abstracts the need to define how to handle new data types if added:
  * to the respective Sets of different Data extensions


### Line Count of source files:
  * git ls-files *.java | xargs wc -l
  * 44 src/annote/AnnoteProcessor.java
  * 13 src/annote/DataSet.java
  * 8 src/annote/FieldProcess.java
  * 8 src/annote/MethodProcess.java
  * 24 src/core/Driver.java
  * 66 src/store/AbstractStore.java
  * 33 src/store/Store.java
  * 196 total

### Output of driver class (if unedited [warning: order may change of elements within a given Set]):

* strSet:
  * Dependency Injection
  * This code example demonstrates how to build custom Data Framworks
  * Annotations
  * Lambda expressions
  * another string
  * Reflection
  * functional interfaces
  * Some techniques you'll see include:

* intSet:
   * 1
   * 2
   * 3
   * 4
   * 5

* charSet:
  * a
  * r
  * c
  * s
  * h


