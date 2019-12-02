package annote;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnoteProcessor {

  private AnnoteProcessor() { // Only to be used as a static method collection
  }

  /**
   * 
   * @param implClass Class which defines Fields tagged with a given annotation
   * @param annote    Annotation to look for in a given implementing Class
   * @param process   Functional Interface: the 'executing code body' when a
   *                  specified Annotation is found on the given Implementing
   *                  Class's field or method
   */
  public static void processFields(Class implClass, Class<? extends Annotation> annote, FieldProcess process) {
    for (Field field : implClass.getDeclaredFields()) {
      if (field.isAnnotationPresent(annote)) {
        try {
          process.run(field);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void processMethods(Class implClass, Class<? extends Annotation> annote, MethodProcess process) {
    for (Method method : implClass.getDeclaredMethods()) {
      if (method.isAnnotationPresent(annote)) {
        try {
          process.run(method);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

}
