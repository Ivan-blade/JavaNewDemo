package design.typecreate.builder.impl;

import design.typecreate.builder.abst.Burger;

public class VegBurger extends Burger {
 
   @Override
   public float price() {
      return 25.0f;
   }
 
   @Override
   public String name() {
      return "Veg Burger";
   }
}