package design.typecreate.abstractfactory.factoryImpl;


import design.typecreate.abstractfactory.baseinterface.Color;
import design.typecreate.singlefactory.baseinterface.Shape;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:53
 * @description
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);

}
