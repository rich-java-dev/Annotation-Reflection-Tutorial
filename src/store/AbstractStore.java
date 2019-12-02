package store;

import java.util.Set;

import annote.AnnoteProcessor;
import annote.DataSet;

public class AbstractStore {

  /*
   * Instances of Functional interface (Field/Method Process) are implemented by
   * an anonymous class via lambdas then passed to AnnoteProcessor.
   */
  
  /**
   * Takes the generic arguments passed in and applies them to data sets defined
   * in the implementing class (if applicable)
   */
  public void push(Object... dataArray) {
    for(Object data : dataArray) {
      // string reference to a 'Set' that would be the 'ideal container' for the given
      // argument.
      final String dataTypeStr = String.format("java.util.Set<%s>", data.getClass().getName());

      AnnoteProcessor.processFields(this.getClass(), DataSet.class, field -> {
        final String fieldType = field.getGenericType().toString(); // Check data type

        if(fieldType.equals(dataTypeStr)) {
          // if match is found, get reference to the Store's/ Set.
          // fairly safe, as string comparison has already been made against data type
          Set<Object> dataSet = (Set<Object>)field.get(this);
          dataSet.add(data);
        }

      });
    }
  }

  public void printSets() {
    AnnoteProcessor.processFields(this.getClass(), DataSet.class, field -> {
      // Expecting that @DataSet is only used on Set<T>
      Set<Object> dataSet = (Set<Object>)field.get(this);

      if(field.getAnnotation(DataSet.class).printSet()) { // Do not print sets if printSet=False
        System.out.println(field.getName() + ":"); // print the Field's name
        for(Object data : dataSet)
          System.out.println(data); // print the elements of the Set
        System.out.println();
      }
    });
  }

  public void clearSet() {
    AnnoteProcessor.processFields(this.getClass(), DataSet.class, field -> { // process method here
      Set<Object> dataSet = (Set<Object>)field.get(this); // Expecting that @DataSet is only used on Set<T>
      dataSet.clear();
    });
  }

}