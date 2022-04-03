package com.ivan;

import java.util.TreeSet;

/**
 * @author hylu.ivan
 * @date 2022/3/27 下午12:18
 * @description
 */
public class Test {

    public static void main(String[] args) {

        TreeSet<Num> treeSet = new TreeSet<>();
        int[] nums = {3,30,34,5,9};

        for (int num : nums) {
            String s = String.valueOf(num);
            Num num1 = new Num(String.valueOf(num));
            treeSet.add(num1);
        }

        for (Num num : treeSet) {
            System.out.print(num.getVal()+"");
        }
        StringBuilder sb = new StringBuilder();
    }
}

class Num implements Comparable<Num>{
    private String val;
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }
    public Num(String val) {
        this.val = val;
    }
    @Override
    public int compareTo(Num o) {
        String val = o.getVal();
        String cur = this.val;
        if (val.length() == cur.length()) {
            return val.compareTo(cur);
        } else {
            String com1 = this.val + o.val;
            String com2 = o.val + this.val;
            return com2.compareTo(com1);
        }

    }
}

