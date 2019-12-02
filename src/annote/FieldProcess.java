package annote;

import java.lang.reflect.Field;

/*
 * Functional interface taking "Field" as an argument
 * The intended usage is to implement in an anonymous class via lambdas and pass to AnnoteProcessor
 */
public interface FieldProcess {

  public void run(Field field) throws Exception;

}
