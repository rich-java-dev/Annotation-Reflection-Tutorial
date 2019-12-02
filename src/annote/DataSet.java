package annote;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * Annotation which behaves as a 'tag', similar to regular interfaces, but is available to look-up at runtime (as meta-data)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSet {

  public boolean printSet() default true; // define a 'method', which behaves as an argument its usage at run-time
}
