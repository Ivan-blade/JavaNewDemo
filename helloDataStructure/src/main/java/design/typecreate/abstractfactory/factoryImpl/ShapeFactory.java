package design.typecreate.abstractfactory.factoryImpl;

import design.typecreate.abstractfactory.baseinterface.Color;
import design.typecreate.singlefactory.baseImpl.Circle;
import design.typecreate.singlefactory.baseImpl.Rectangle;
import design.typecreate.singlefactory.baseImpl.Square;
import design.typecreate.singlefactory.baseinterface.Shape;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:54
 * @description
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}