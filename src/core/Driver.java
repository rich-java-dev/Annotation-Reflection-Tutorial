package core;

import data.Day;
import data.Num;
import data.Str;
import store.Store;

public class Driver {

  public static void main(String[] args) {

    Store store = Store.getInstance();

    store.push(new Str("Hello world of custom Framework building"));
    store.push(new Str("This code example demonstrates how to build custom Data Framworks"));

    store.push(new Day(1991, 24, 1));
    store.push(new Day(2019, 10, 24));

    store.push(new Num(1));
    store.push(new Num(10.05));

    store.push(new Str("Using some basic Annotations and Reflection, its easy to produce light-weight 'Spring-inspired' frameworks"));
    store.push(new Str("I was inspired by the usage of annotations in Spring, and had to figure out exactly how they worked"));
    store.push(new Str("This set won't print, even though it exists, and is properly built out, because @Data(print=false) "));

    store.printSets();

  }

}