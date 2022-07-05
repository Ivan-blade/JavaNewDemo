package design.typecreate.builder.abst;

import design.typecreate.builder.Item;
import design.typecreate.builder.Packing;
import design.typecreate.builder.impl.Wrapper;

public abstract class Burger implements Item {
 
   @Override
   public Packing packing() {
      return new Wrapper();
   }
 
   @Override
   public abstract float price();
}