package oop;

class Course {
    String name;
    int credit;
    Course pre_course;

    public Course() {
        this("", 0, null);
    }

    public Course(String name, int credit, Course pre_course) {
        this.name = name;
        this.credit = credit;
        this.pre_course = pre_course;
    }
}
public class JavaAttribute {
    public static void main(String[] args) {
        Course ca = new Course();
        Course cb = new Course("C Programming",3,null);
        ca.name = "Object Oriented Programming";
        ca.credit = 3;
        ca.pre_course = cb;
        System.out.println(ca.name);
        System.out.println(ca.credit);
        System.out.println(ca.pre_course.name);
    }
}
