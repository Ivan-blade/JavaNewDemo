package design.abstractfactory.baseImpl;


import design.abstractfactory.baseinterface.Color;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:51
 * @description
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}