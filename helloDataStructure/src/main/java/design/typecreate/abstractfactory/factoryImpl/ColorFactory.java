package design.typecreate.abstractfactory.factoryImpl;


import design.typecreate.abstractfactory.baseImpl.Blue;
import design.typecreate.abstractfactory.baseImpl.Green;
import design.typecreate.abstractfactory.baseImpl.Red;
import design.typecreate.abstractfactory.baseinterface.Color;
import design.typecreate.singlefactory.baseinterface.Shape;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:56
 * @description
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}