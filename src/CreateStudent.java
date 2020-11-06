import java.io.*;

public class CreateStudent {
    public static void main(String[] args) throws Exception {
        // 1.new一个对象此方式会调用构造函数
        Student student1 = new Student();
        student1.setAge("20");
        student1.setName("张三");
        student1.setSex("男");
        System.out.println("student1 === " + student1.toString());
        // 2.用反射创建对象会调用构造函数
        Class<Student> clazz = Student.class;
        Student student2 = clazz.newInstance();
        student2.setAge("18");
        student2.setName("李四");
        student2.setSex("男");
        System.out.println("student2 === " + student2.toString());
        // 3.clone一个对象是在内存上对已有对象的影印，所以不会调用构造函数

            Student student3 = (Student) student1.clone();
        System.out.println("student3 === " + student3.toString());
        // 4.运用反序列化手段运用反序列化手段，调用 java.io.ObjectInputStream 对象的 readObject() 方法。
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("D:/Student.text")));
        oo.writeObject(student2);
        oo.close();
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File("D:/Student.text")));
        Student student4 = (Student) oi.readObject();
        oi.close();
        System.out.println("student4 === " + student4.toString());
    }
}
