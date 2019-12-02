package annote;

import java.lang.reflect.Method;

/*
 * Functional interface taking "Method" as an argument
 * The intended usage is to implement in an anonymous class via lambdas and pass to AnnoteProcessor
 */
public interface MethodProcess {

  public void run(Method method) throws Exception;

}
