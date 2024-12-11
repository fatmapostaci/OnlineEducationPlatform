import java.util.ArrayList;
import java.util.List;

public class Student {

    String name;
    int age;
    List<Course> courseList;


    public Student(String name, int age, List<Course> courseList) {
        this.name = name;
        this.age = age;
        this.courseList = courseList;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.courseList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", List=" + courseList +
                '}';
    }
}
