package com.ivan.utils;

import com.ivan.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hylu.ivan
 * @date 2022/2/9 下午8:00
 * @description
 */
public class FileUtils {

    /**
     * 按行读取文件
     * @param path
     * @return
     */
    public static List<String> readFileByLines(String path) {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        List<String> list = new ArrayList<>();
        try {
            inputStream = new FileInputStream(path);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String str = null;
            while((str = bufferedReader.readLine()) != null)
            {
                list.add(str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //close
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }
    }

    /**
     * 将对象写入文件
     * @param path
     * @param list
     */
    public static void writeFilesByObject(String path,List<Object> list) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(list);
            System.out.println("output over");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 从文件中读取对象
     * @param path
     * @return 可以转换为List<T></>的Object对象
     */
    public static Object readFilesByObject(String path) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            Object obj= ois.readObject();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 快速将一个指定位置文件拷贝成另一个文件
     * @param originPath
     * @param targetPath
     */
    public static void quickCopy(String originPath,String targetPath) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(originPath);
            outputStream = new FileOutputStream(targetPath);
            inputStream.transferTo(outputStream);
            // 快速实现文件拷贝，底层使用的是带有缓冲区的read和write
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

//        按行读文件
//        List<String> list = readFileByLines("data/readFileByLines/data.txt");
//        for (String s : list) {
//            System.out.println(s);
//        }

//        写文件
        List<Object> list = new ArrayList<>();
        User user = new User("luna","123456","110");
        User user1 = new User("saber","234567","119");
        list.add(user);
        list.add(user1);
        writeFilesByObject("data/objectSream/data.txt",list);

//        读文件
//        Object object = readFilesByObject("data/objectSream/data.txt");
//        List<User> res = (List<User>)(object);
//        for (User re : res) {
//            System.out.println(re);
//        }

//        从map中获取对象
//        Map<String,Object> map = new HashMap<>();
//        map.put("username","luna");
//        map.put("password","123456");
//        map.put("phonenum","110");
//
//        Object object = getObjectFromMap(map, "com.ivan.model.User");
//        System.out.println((User)object);

    }
}
