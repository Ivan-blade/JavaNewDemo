package design.typecreate.singlefactory.baseImpl;


import design.typecreate.singlefactory.baseinterface.Shape;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:08
 * @description
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
