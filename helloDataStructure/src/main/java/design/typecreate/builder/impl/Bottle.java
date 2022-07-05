package design.typecreate.builder.impl;

import design.typecreate.builder.Packing;

public class Bottle implements Packing {
 
   @Override
   public String pack() {
      return "Bottle";
   }
}