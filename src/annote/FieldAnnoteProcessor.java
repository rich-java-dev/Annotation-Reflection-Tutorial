package annote;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldAnnoteProcessor {

  /**
   * @param process
   *        Functional Interface, zero argument, the 'execution' when a sepcific Annotation is found on a given Implementing Class's field (data structure)
   * @param implClass
   *        The Class which defines Fields tagged with the given annotation
   * @param annote
   *        The Annotation to look for in a given Implementing Class
   */
  public void process(FieldProcess process, Class implClass, Class<? extends Annotation> annote) {
    for(Field field : implClass.getDeclaredFields()) {
      if(field.isAnnotationPresent(annote)) {
        try {
          process.run(field);
        }
        catch(Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

}
