package design.typecreate.abstractfactory.baseImpl;


import design.typecreate.abstractfactory.baseinterface.Color;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:51
 * @description
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}