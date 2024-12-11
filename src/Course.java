public class Course {

    String name;
    String category;
    Teacher teacher;

    public Course(String name, String category, Teacher teacher) {

        this.category = category;

        if (this.category.equals(teacher.category)){
            this.name = name;
            this.teacher = teacher;
        }
        else {
            System.out.println("Lecture category does not match with teacher category");
        }
    }

    public Course(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher='" + teacher.name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
