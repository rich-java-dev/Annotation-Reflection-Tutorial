package annote;

import java.lang.reflect.Field;

// Bare bones Functional interface taking "Field" as an argument
public interface FieldProcess {
  public void run(Field field) throws Exception;
}
