package com.maciejgiza.service;

import java.util.ServiceLoader;

public class NameApp {

  private static ServiceLoader<Name> names;

  private static void printName() {
    names = ServiceLoader.load(Name.class);
    names.forEach(n -> {
        System.out.println(n.getName() + " -> I'm a return from -> " + n.getClass().getSimpleName());
    });
  }

  public static void main(String[] args) {
    printName();
  }
}
