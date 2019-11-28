package annote;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldAnnoteProcessor {

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
