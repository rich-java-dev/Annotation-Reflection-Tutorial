package store;

import java.util.Set;
import annote.DataSet;
import annote.FieldAnnoteProcessor;
import data.Data;

public class AbstractStore {

  Class<? extends AbstractStore> implClass;

  // Dependency injection: Pass in implementing class to get proper reference to use reflection 'tricks'
  protected AbstractStore(Class<? extends AbstractStore> implClass) {
    this.implClass = implClass;
  }

  /*
   * The following methods use dependency injection:
   * Instances of FieldAnnoteProcessor can simulate a functional interface by creating new instances and passing in an implementation of the interface "FieldProcess"
   * This is great because Classes (even abstract) cannot behave as interfaces/use lambda syntax. This however lets use lambdas by defining the interface seperately
   */

  /**
   * Takes the provided object 'Data' which is a wrapper/container, determines
   * prevents having to use repetitive constructs such is "if instanceof A... else if instanceof B... else if instanceof C...
   * Iterates over the Fields of the implementing class, and determines which
   */
  public void push(Data data) {
    // get a string reference to a 'Set' that would be the 'ideal container' for the given argument.
    final String dataTypeStr = String.format("java.util.Set<%s>", data.getClass().getName());

    new FieldAnnoteProcessor().process(field -> {
      final String fieldType = field.getGenericType().toString(); // Check data type
      if(fieldType.equals(dataTypeStr)) {
        Set<Data> dataSet = (Set<Data>)field.get(this); // if match is found, get reference to the Store's Set.
        dataSet.add(data);
      }

    }, implClass, DataSet.class);
  }

  public void printSets() {
    new FieldAnnoteProcessor().process(field -> {
      Set<Data> dataSet = (Set<Data>)field.get(this);
      System.out.println(field.getName() + ":"); // print the Fields name (as defined in the implementing class)
      for(Data data : dataSet)
        System.out.println(data.val); // print the elements of the Set
      System.out.println();
    }, implClass, DataSet.class);
  }

  public void clearSet() {
    new FieldAnnoteProcessor().process(field -> { // process method here
      Set<Data> dataSet = (Set<Data>)field.get(this);
      dataSet.clear();

    }, implClass, DataSet.class);
  }

}