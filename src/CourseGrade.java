public class CourseGrade {

    Student student;
    Course course;
    double grade;

    public CourseGrade(double grade, Course course, Student student) {
        this.grade = grade;
        this.course = course;
        this.student = student;
    }

    @Override
    public String toString() {
        return "CourseGrade{" +
                "student=" + student +
                ", course=" + course +
                ", grade=" + grade +
                '}';
    }
}
