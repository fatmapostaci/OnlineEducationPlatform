import java.util.List;

public class Teacher {

    String name;
    String category;



    public Teacher(String name,String category) {
        this.name = name;
        this.category=category;



    }

    public Teacher(String name, String category, Course course) {
        this.name = name;
        this.category = category;

    }

    @Override
    public String toString() {
        return "\nTeacher{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

}

