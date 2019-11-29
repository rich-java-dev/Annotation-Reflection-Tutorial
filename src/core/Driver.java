package core;

import store.Store;

public class Driver {

	public static void main(String[] args) {

		Store store = Store.getInstance();

		store.push("This code example demonstrates how to build custom Data Framworks");
		store.push("Some techniques you'll see include: Reflection, Dependency Injection, Annotations, Lambda expressions/functional interfaces");

		store.push(1.01, 1.02, 1.03); //

		store.push(1, 2, 3, 4, 5, "another string"); // ints should go to intSet, while String to strSet

		store.printSets();
		store.clearSet();
	}

}