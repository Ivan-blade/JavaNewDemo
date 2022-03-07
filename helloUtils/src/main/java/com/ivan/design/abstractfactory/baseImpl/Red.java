package com.ivan.design.abstractfactory.baseImpl;

import com.ivan.design.abstractfactory.baseinterface.Color;

/**
 * @author hylu.ivan
 * @date 2022/3/7 下午10:51
 * @description
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}