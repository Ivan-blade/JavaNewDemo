package com.ivan.design.singletom;

/**
 * @author hylu.ivan
 * @date 2022/3/9 下午11:11
 * @description  单例懒汉式
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
 * 因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class SingleLazyObject {

    //创建 SingleObject 的一个引用
    private static SingleLazyObject instance;

    //让构造函数为 private，这样该类就不会被实例化
    private SingleLazyObject(){}

    /**
     * 第一次调用时初始化对象，但是不安全
     * @return
     */
    public static SingleLazyObject getInstance() {
        if (instance == null) {
            instance = new SingleLazyObject();
        }
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
        SingleLazyObject object = SingleLazyObject.getInstance();

        //显示消息
        object.showMessage();
    }
}
