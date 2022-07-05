package home.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author hylu.ivan
 * @date 2022/6/13 下午10:13
 * @description
 */
public class Test {

    public static List<String> getLines() {
        List<String> list = new ArrayList<>();
        String str1 = "16 111";
        String str2 = "16 112";
        String str3 = "17 111";
        list.add(str1);
        list.add(str2);
        list.add(str3);
        return list;

    }


    public static void main(String[] args) {

        List<String> lines = getLines();

        // 对班级里的学生进行排序，优先根据年龄排序，如果年龄相等根据学号排序
        PriorityQueue<Student> queue = new PriorityQueue<>();
//        TreeSet<Student> treeSet = new TreeSet<>();
        for (String line : lines) {
            String[] s = line.split(" ");
            Student student = new Student(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
//            treeSet.add(student);
            queue.offer(student);
        }

        while (queue.size() != 0) {
            System.out.println(queue.poll());
        }

//        System.out.println(treeSet);

    }
}

class Student implements Comparable<Student>{
    private int age;
    private int no;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", no=" + no +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Student() {
    }

    public Student(int age, int no) {
        this.age = age;
        this.no = no;
    }

    @Override
    public int compareTo(Student o) {
        int subAge = this.age - o.age;
        int subNo =  - this.no + o.no;
        if (subAge != 0) {
            return subAge;
        } else {
            return subNo;
        }
    }
}

