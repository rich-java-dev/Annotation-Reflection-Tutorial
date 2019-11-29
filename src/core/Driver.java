package core;

import java.sql.Date;

import store.Store;

public class Driver {

	public static void main(String[] args) {

		Store store = Store.getInstance();

		store.push("This code example demonstrates how to build custom Data Framworks");
		store.push("Some techniques you'll see include:");
		store.push("Reflection", "Dependency Injection", "Annotations", "Lambda expressions", "functional interfaces");

		store.push(1.01, 1.02, 1.03); // values passed in are added to the doubleSet, but will not print
		store.push(1, 2, 3, 4, 5, "another string"); // ints should go to intSet, while String to strSet
		store.push(Date.valueOf("2019-11-29"), new Date(System.currentTimeMillis()));
		store.push('c', 'h', 'a', 'r', 's'); // there is not set defining chars, so data doesn't get pushed anywhere

		store.printSets();
		store.clearSet();
	}

}