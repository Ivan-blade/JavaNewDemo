package design.typecreate.builder.impl;

import design.typecreate.builder.abst.ColdDrink;

public class Pepsi extends ColdDrink {
 
   @Override
   public float price() {
      return 35.0f;
   }
 
   @Override
   public String name() {
      return "Pepsi";
   }
}