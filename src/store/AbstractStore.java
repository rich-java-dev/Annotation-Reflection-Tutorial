package store;

import java.lang.reflect.Field;
import java.util.Set;
import annote.DataSet;
import data.Data;

public class AbstractStore {

  Class<? extends AbstractStore> implClass;

  // Dependency injection: Pass in implementing class to get proper reference to use reflection 'tricks'
  protected AbstractStore(Class<? extends AbstractStore> implClass) {
    this.implClass = implClass;
  }

  // Reflection Methods tying into Annotations

  /**
   * Takes the provided object 'Data' which is a wrapper/container, determines
   * 
   * prevents having to use repetitive constructs such is "if instanceof A... else if instanceof B... else if instanceof C...
   * 
   * Iterates over the Fields of the implementing class, and determines which
   * 
   */
  public void push(Data data) {

    // get a string reference to a 'Set' that would be the 'ideal container' for the given argument.
    final String dataTypeStr = String.format("java.util.Set<%s>", data.getClass().getName());

    // Iterator over list of a fields within Store (including private members)
    for(Field field : implClass.getDeclaredFields()) {

      if(field.isAnnotationPresent(DataSet.class)) { // Checks if @DataSet is tagged on the Field
        final String fieldType = field.getGenericType().toString(); // Check data type

        if(fieldType.equals(dataTypeStr)) { // Check if string representations of data type matches the set.
          try {
            Set<Data> dataSet = (Set<Data>)field.get(this); // if match is found, get reference to the Store's Set.
            dataSet.add(data);
          }
          catch(Exception e) {
            e.printStackTrace();
          }

        }

      }

    }

  }

  /*
   * Similar to 'push(Data)' method;
   * Uses reflection to iterate over annotated Sets of the implementing class and prints their members
   * 
   */
  @SuppressWarnings("unchecked")
  public void printSets() {

    for(Field field : implClass.getDeclaredFields()) {

      if(field.isAnnotationPresent(DataSet.class)) { // Checks if @DataSet is tagged on the Field
        DataSet annote = field.getAnnotation(DataSet.class);

        if(annote.print()) {
          try {
            Set<Data> dataSet = (Set<Data>)field.get(this); // if match is found, get reference to the Store's Set.
            System.out.println(field.getName() + ":");
            for(Data dataObj : dataSet)
              System.out.println(dataObj.val);

            System.out.println("");

          }
          catch(Exception e) {
            e.printStackTrace();
          }
        }

      }

    }

  }

}
