package design.typecreate.abstractfactory;


import design.typecreate.abstractfactory.factoryImpl.AbstractFactory;
import design.typecreate.abstractfactory.factoryImpl.ColorFactory;
import design.typecreate.abstractfactory.factoryImpl.ShapeFactory;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午11:01
 * @description
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
