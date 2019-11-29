package store;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import annote.DataSet;

/** A basic implementation of the Abstract Store. Defines Data Sets **/
public class Store extends AbstractStore {

	// Important the Sets are not private to access via the AbstractStore

	@DataSet
	protected Set<String> strSet = new HashSet<>();

	@DataSet
	protected Set<Integer> intSet = new HashSet<>();

	@DataSet(printSet = false)
	Set<Double> doubleSet = new HashSet<>();

	@DataSet(printSet = true) // default: same effect is not including 'printSet'
	protected Set<Date> dateSet = new HashSet<>();

	// Singleton pattern
	private static final Store instance = new Store();

	private Store() {
		super(Store.class); // dependency injection
	}

	public static synchronized Store getInstance() {
		return instance;
	}

}