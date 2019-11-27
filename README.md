# Annotation-Reflection-Tutorial
A basic implementation of a Data Store using Java Spring Framework inspired pattern.

The purpose of this example code is to demonstrate a novel design pattern using less than 200 lines of code.

General Structure:

* A DataStore is defined which extends behavior from an AbstractDataStore
  * This allows for cleanly separating the Data sets to be stored from the Annotation/Reflection methods
* The DataStore passes its class definition to the AbstractStore (Dependency Injection) in order to get proper reference to the Implementing Class.
* The DataStore implements a singleton pattern, with a single instance. This is not required but centralizes the DataStore
* Wrapper data classes are defined, which gives a common base class (Data), and type for instances
* The Data is pushed to the Store, and using Reflection assigns the Data to the proper Set/Collection, based on being 'tagged' by the Annotation '@DataSet'
  * This style of coding prevents the requirement to create long if/else blocks to determine how to apply a common class (Data) to the respective Sets of different Data implementations
 

Line Count of source files:

$ git ls-files *.java | xargs wc -l
   9 src/annote/DataSet.java
  30 src/core/Driver.java
   6 src/data/Data.java
   8 src/data/Day.java
  14 src/data/Num.java
   8 src/data/Str.java
  89 src/store/AbstractStore.java
  35 src/store/Store.java
 199 total
