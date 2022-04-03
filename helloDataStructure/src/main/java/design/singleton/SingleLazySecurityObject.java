package design.singleton;

/**
 * @author hylu.ivan
 * @date 2022/3/9 下午11:11
 * @description  单例懒汉安全式
 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 */
public class SingleLazySecurityObject {

    //创建 SingleObject 的一个引用
    private static SingleLazySecurityObject instance;

    //让构造函数为 private，这样该类就不会被实例化
    private SingleLazySecurityObject(){}

    /**
     * 第一次调用时初始化对象，但是不安全
     * @return
     */
    public static synchronized SingleLazySecurityObject getInstance() {
        if (instance == null) {
            instance = new SingleLazySecurityObject();
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
        SingleLazySecurityObject object = SingleLazySecurityObject.getInstance();

        //显示消息
        object.showMessage();
    }
}
