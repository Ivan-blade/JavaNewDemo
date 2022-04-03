package design.abstractfactory;


import design.abstractfactory.baseinterface.Color;
import design.abstractfactory.factoryImpl.AbstractFactory;
import design.singlefactory.baseinterface.Shape;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午11:02
 * @description
 */
public class AbstractFactoryPatternDemo {

    /**
     * 1.根据需求分别创建几个接口shape,color
     * 2.编写接口的实体类
     * 3.创建抽象类，通过编写抽象方法获取工厂abstractFactory
     * 4.创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。ColorFactory,ShapeFactory
     * 5.创建一个工厂创造器/生成器类，通过传递信息来获取不同工厂。FactoryProducer
     * 6.使用 FactoryProducer 来获取 AbstractFactory，通过传递类型信息来获取实体类的对象。
     * @param args
     */
    public static void main(String[] args) {

        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取形状为 Circle 的对象
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取形状为 Rectangle 的对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取形状为 Square 的对象
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        //获取颜色为 Red 的对象
        Color color1 = colorFactory.getColor("RED");

        //调用 Red 的 fill 方法
        color1.fill();

        //获取颜色为 Green 的对象
        Color color2 = colorFactory.getColor("Green");

        //调用 Green 的 fill 方法
        color2.fill();

        //获取颜色为 Blue 的对象
        Color color3 = colorFactory.getColor("BLUE");

        //调用 Blue 的 fill 方法
        color3.fill();
    }
}