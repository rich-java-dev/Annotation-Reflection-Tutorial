package store;

import java.util.Set;

import annote.AnnoteProcessor;
import annote.DataSet;

public class AbstractStore {

	Class<? extends AbstractStore> implClass;

	// Dependency injection: Pass in implementing class to get proper reference to
	// use reflection 'tricks'
	protected AbstractStore(Class<? extends AbstractStore> implClass) {
		this.implClass = implClass;
	}

	/*
	 * Instances of Functional interface (Field/Method Process)ares implemented by
	 * an anonymous class via lambda expressions, then passed (injected) into the
	 * AnnoteProcessor. 
	 */

	/**
	 * Takes the provided object 'Data' and iterates over the Fields of the
	 * implementing class, and determines which
	 */
	public void push(Object... dataArray) {
		for (Object data : dataArray) {
			// string reference to a 'Set' that would be the 'ideal container' for the given
			// argument.
			final String dataTypeStr = String.format("java.util.Set<%s>", data.getClass().getName());

			AnnoteProcessor.processFields(field -> {
				final String fieldType = field.getGenericType().toString(); // Check data type

				if (fieldType.equals(dataTypeStr)) {
					// if match is found, get reference to the Store's/ Set.
					Set<Object> dataSet = (Set<Object>) field.get(this);
					dataSet.add(data);
				}

			}, implClass, DataSet.class);
		}
	}

	public void printSets() {
		AnnoteProcessor.processFields(field -> {
			Set<Object> dataSet = (Set<Object>) field.get(this);
			System.out.println(field.getName() + ":"); // print the Fields name (as defined in the implementing class)
			for (Object data : dataSet)
				System.out.println(data); // print the elements of the Set
			System.out.println();
		}, implClass, DataSet.class);
	}

	public void clearSet() {
		AnnoteProcessor.processFields(field -> { // process method here
			Set<Object> dataSet = (Set<Object>) field.get(this);
			dataSet.clear();

		}, implClass, DataSet.class);
	}

}