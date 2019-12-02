package store;

import java.util.HashSet;
import java.util.Set;
import annote.DataSet;

/**
 * A basic implementation of the Abstract Store. Defines Data Sets annotated
 * with @DataSet
 **/
public class Store extends AbstractStore {
  // Important the Sets are not private to access via the AbstractStore

  @DataSet
  protected Set<String> strSet = new HashSet<>();

  @DataSet
  protected Set<Integer> intSet = new HashSet<>();

  @DataSet(printSet = false)
  Set<Double> doubleSet = new HashSet<>();

  @DataSet(printSet = true) // default: same effect is not including 'printSet'
  protected Set<Character> charSet = new HashSet<>();

  // Singleton pattern
  private static final Store instance = new Store();

  private Store() {
  }

  public static synchronized Store getInstance() {
    return instance;
  }

}