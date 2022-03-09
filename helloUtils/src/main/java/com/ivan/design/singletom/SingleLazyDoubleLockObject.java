package com.ivan.design.singletom;

/**
 * @author hylu.ivan
 * @date 2022/3/9 下午11:11
 * @description  单例懒汉双重检测锁
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class SingleLazyDoubleLockObject {

    private volatile static SingleLazyDoubleLockObject singleton;

    private SingleLazyDoubleLockObject (){}

    public static SingleLazyDoubleLockObject getSingleton() {
        if (singleton == null) {
            synchronized (SingleLazyDoubleLockObject.class) {
                if (singleton == null) {
                    singleton = new SingleLazyDoubleLockObject();
                }
            }
        }
        return singleton;

    }
        /**
         * 1.创建单例类（生成一个单例对象，私有化构造方法，提供get方法返回对象）
         * 2.调用单例类获取对象并使用
         * @param args
         */
    public static void main(String[] args) {

        //获取唯一可用的对象
        SingleLazyDoubleLockObject object = SingleLazyDoubleLockObject.getSingleton();

    }
}
