package design.typecreate.singlefactory.factoryImpl;


import design.typecreate.singlefactory.baseImpl.Circle;
import design.typecreate.singlefactory.baseImpl.Rectangle;
import design.typecreate.singlefactory.baseImpl.Square;
import design.typecreate.singlefactory.baseinterface.Shape;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:11
 * @description
 */
public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
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
}
