package ClassTest;

/**
 * @author hylu.ivan
 * @date 2022/3/12 下午12:49
 * @description
 */
public enum  EnumTest {

    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLO("黄色", 4);

    private String name ;
    private int index ;

    private EnumTest( String name , int index ){
        this.name = name ;
        this.index = index ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
