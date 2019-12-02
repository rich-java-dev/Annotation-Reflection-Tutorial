package annote;

import java.lang.reflect.Method;

// Bare bones Functional interface taking "Method" as an argument
public interface MethodProcess {
  public void run(Method method) throws Exception;
}
