package core;

import data.Day;
import data.Num;
import data.Str;
import store.Store;

public class Driver {

  public static void main(String[] args) {

    Store store = Store.getInstance();

    store.push(new Str("This code example demonstrates how to build custom Data Framworks"));
    store.push(new Str("Some techniques you'll see include: Reflection, Dependency Injection, Annotations, Lambda expressions/functional interfaces"));

    store.push(new Day(2000, 1, 1));
    store.push(new Day(2019, 11, 27));

    store.push(new Num(1));
    store.push(new Num(10.05));

    store.printSets();
    store.clearSet();
  }

}