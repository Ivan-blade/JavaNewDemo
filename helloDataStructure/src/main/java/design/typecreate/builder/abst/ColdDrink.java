package design.typecreate.builder.abst;

import design.typecreate.builder.Item;
import design.typecreate.builder.Packing;
import design.typecreate.builder.impl.Bottle;

public abstract class ColdDrink implements Item {
 
    @Override
    public Packing packing() {
       return new Bottle();
    }
 
    @Override
    public abstract float price();
}