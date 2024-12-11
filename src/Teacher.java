import java.util.List;

public class Teacher {

    String name;
    String category;
    Course course;


    public Teacher(String name,String category) {
        this.name = name;
        this.category=category;


    }

    public Teacher(String name, String category, Course course) {
        this.name = name;
        this.category = category;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", course=" + course +
                '}';
    }
}
}

