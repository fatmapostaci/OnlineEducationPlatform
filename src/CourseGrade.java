public class CourseGrade {

    Student student;
    Course course;
    double grade;

    public CourseGrade(double grade, Course course, Student student) {

        String names = student.courseList.toString();
        //Student courseName ile Course courseName eşleşmeli ((öğrencinin aldığı derslerin içinde bu course da varsa constructor atamaları yapar))
        if ( names.contains( course.name )){
            this.grade = grade;
            this.course = course;
            this.student = student;

        }
        else System.out.println( student.name + " öğrencisine " + course.name + " notu verilemedi. (bu dersi almıyor)");
    }

    @Override
    public String toString() {
        return "\nCourseGrade{" +
                "student=" + student +
                ", course=" + course +
                ", grade=" + grade +
                '}';
    }
}
