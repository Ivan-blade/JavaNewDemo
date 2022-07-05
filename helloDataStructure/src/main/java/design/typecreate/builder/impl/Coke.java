package design.typecreate.builder.impl;

import design.typecreate.builder.abst.ColdDrink;

public class Coke extends ColdDrink {
 
   @Override
   public float price() {
      return 30.0f;
   }
 
   @Override
   public String name() {
      return "Coke";
   }
}