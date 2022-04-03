package ClassTest;

import utils.StringUtils;

/**
 * @author hylu.ivan
 * @date 2022/3/26 上午11:55
 * @description
 */
public class ConversionTest {

    /**
     * 其他进制转十进制，用Long可以转十六进制，Integer可能会溢出
     * Integer.parseInt("1001",2) 将1001表示的2进制数转为十进制
     * @param str 目标字符串
     * @param radix 字符串所表示数字的进制
     * @return
     */
    public static Long convertToDemical(String str,int radix) {
        Long aLong = Long.valueOf(str, radix);
        return aLong;
    }

    /**
     * 十进制转二进制
     * @param str
     * @return
     */
    public static String convertToBinary(String str) {
        Long aLong = Long.valueOf(str);
        String s = Long.toBinaryString(aLong);
        return s;
    }

    /**
     * 十进制转八进制
     * @param str
     * @return
     */
    public static String convertToHex(String str) {
        Long aLong = Long.valueOf(str);
        String s = Long.toHexString(aLong);
        return s;
    }

    /**
     * 十进制转十六进制
     * @param str
     * @return
     */
    public static String convertToOctal(String str) {
        Long aLong = Long.valueOf(str);
        String s = Long.toOctalString(aLong);
        return s;
    }

    /**
     * 四舍五入
     * @param i
     * @return
     */
    public static double getNumPoint01(double i) {
        return Math.round(i);
    }

    /**
     * 去除小数点
     * @param i
     * @return
     */
    public static double getNumPoint02(double i) {
        return Math.floor(i);
    }

    public static void testBaseConvert() {
        // 十六进制字符串转十进制
        Long aa = convertToDemical("AA", 16);
        System.out.println(aa);

        String s = String.valueOf(aa);
        String s1 = convertToBinary(s);
        String s2 = convertToHex(s);
        String s3 = convertToOctal(s);
        System.out.println(StringUtils.combineParams("\t","","",s1,s2,s3));
    }

    public static void main(String[] args) {


        double numPoint = getNumPoint02(3.6);
        System.out.println(numPoint);
    }
}