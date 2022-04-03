package ClassTest;

/**
 * @author hylu.ivan
 * @date 2022/3/26 上午12:54
 * @description
 */
public class CharacterTest {

    public static void testStr(String str) {
        int lower = 0;
        int upper = 0;
        int num = 0;
        int other = 0;

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            int i = (int)aChar;
            if(i >= 65 && i <= 96) {
                upper++;
            } else if (i >= 97 && i <= 122) {
                lower++;
            } else if(i >= 48 && i<= 57) {
                num++;
            } else {
                other++;
            }
        }
        boolean b = lower > 0 && upper > 0 && num > 0 && other > 0;

        System.out.println(b);
    }

    public static void main(String[] args) {

        testStr("1aD!");
    }
}
