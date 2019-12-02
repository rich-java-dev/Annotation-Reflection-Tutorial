package annote;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * Annotation which behaves as a 'tag', intended to be used on Set<?> fields within a class extending the Abstract Store
 * This tag is then looked up by the AbstractStore and delegates tasks to be performed on the Set<?> objects
 * Available at run-time given the RententionPolicy annote
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSet {
  
  public boolean printSet() default true; // printSet determines whether or not to print the elements of the expected Set<?> flagged this annotation
}
