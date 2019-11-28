# Annotation-Reflection-Tutorial
## A basic implementation of a Data Store using Java Spring Framework inspired pattern.

### The purpose of this example code is to demonstrate a novel design pattern using less than 200 lines of code.

### General Structure:
* Annotations are a great tool, and really do behave as an extension of Interfaces:
  * They are used to tag (like zero method interfaces) other parts of code with meta-data.
  * Runtime RetentionPolicy allows Reflection classes to access these tags and handle the actual logic/meaning of the annotation
* Store is defined which extends behavior from an AbstractStore
  * This allows for cleanly separating the Data sets to be stored from the Annotation/Reflection methods
  * Reflection is at the heart of this pattern design (Its the underlying mechanism that makes this possible
* The Store passes its class definition to the AbstractStore (Dependency Injection) in order to get proper reference to the Implementing Class.
  * This can be extended to behave with other Store implementations
* Store implements a singleton pattern. This is not required but centralizes the Store/any class can access this single instance.
* Wrapper data classes are defined, which gives a common base class (Data), and type for instances.
* The Data is pushed to the Store, and using Reflection assigns the Data to the proper Set/Collection, based on being 'tagged' by the Annotation '@DataSet'
  * This style of coding prevents the requirement to create long if/else blocks to determine how to apply a common class (Data) to the respective Sets of different Data implementations
* Annotations are a great tool, and really do behave as an extension of Interfaces:
  * They are used to tag (like zero method interfaces) other parts of code with meta-data.
  * Runtime RetentionPolicy allows Reflection classes to access these tags and handle the actual logic/meaning of the annotation

* Line Count of source files:
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


