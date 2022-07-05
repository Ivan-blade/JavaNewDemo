package design.typecreate.builder.impl;

import design.typecreate.builder.Packing;

public class Wrapper implements Packing {
 
   @Override
   public String pack() {
      return "Wrapper";
   }
}