package com.ivan.design.singlefactory;

import com.ivan.design.singlefactory.baseinterface.Shape;
import com.ivan.design.singlefactory.factoryImpl.ShapeFactory;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:11
 * @description
 */
public class FactoryPatternDemo {

    /**
     * 简单工厂实现步骤
     * 1.创建接口
     * 2.根据需求创建接口的实现类
     * 3.创建工厂，生成基于给定信息的实现类对象
     * 4.调用工厂，通过传递类型信息获取实现类对象
     * @param args
     */
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
