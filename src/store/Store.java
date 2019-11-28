package store;

import java.util.HashSet;
import java.util.Set;
import annote.DataSet;
import data.Day;
import data.Num;
import data.Str;

public class Store extends AbstractStore {

  // Data Store/Collections
  // Important the Sets are not public in order to access them via the AbstractStore

  @DataSet
  protected Set<Str> strSet = new HashSet<>();

  @DataSet
  protected Set<Num> numSet = new HashSet<>();

  @DataSet
  protected Set<Day> daySet = new HashSet<>();

  // Singleton pattern
  private static Store instance = new Store();

  private Store() {
    super(Store.class); // dependency injection
  }

  public static synchronized Store getInstance() {
    return instance;
  }

}