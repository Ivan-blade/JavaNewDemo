package com.ivan.design.singletom;

/**
 * @author hylu.ivan
 * @date 2022/3/9 下午11:11
 * @description  单例饿汉式
 * 描述：这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 * 它基于 classloader 机制避免了多线程的同步问题，
 * 不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
 * 在单例模式中大多数都是调用 getInstance 方法，
 * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
 * 这时候初始化 instance 显然没有达到 lazy loading 的效果。
 */
public class SingleHungryObject {

    //创建 SingleObject 的一个对象
    private static SingleHungryObject instance = new SingleHungryObject();

    //让构造函数为 private，这样该类就不会被实例化
    private SingleHungryObject(){}

    //获取唯一可用的对象
    public static SingleHungryObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }

    /**
     * 1.创建单例类（生成一个单例对象，私有化构造方法，提供get方法返回对象）
     * 2.调用单例类获取对象并使用
     * @param args
     */
    public static void main(String[] args) {


        //获取唯一可用的对象
        SingleHungryObject object = SingleHungryObject.getInstance();

        //显示消息
        object.showMessage();
    }
}
