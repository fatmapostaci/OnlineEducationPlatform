import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Runner {
    public static void main(String[] args) {


        Teacher suleyman = new Teacher("Suleymen","Computer Sciences" );
        Teacher firdevs = new Teacher("Firdevs","Education Sciences" );


        Course math = new Course("Mathematic", "Education Sciences");
        Course bio = new Course("Biology", "Education Sciences");
        Course sdet = new Course("SDET", "Computer Sciences",suleyman);


        Student bilal = new Student("Bilal",37,List.of(math,bio));


        Student fatma = new Student("Fatma", 37);
        fatma.courseList.addAll( List.of( math, bio, sdet ));

        Student ali = new Student("Ali", 37);
        ali.courseList.add(  sdet );
        System.out.println("ali = " + ali);


        Student ahmet = new Student("Ahmet",12);
        ahmet.courseList.add( bio );
        ahmet.courseList.add(sdet);
        System.out.println("ahmet = " + ahmet);

        bio.teacher = firdevs;
        System.out.println("bio = " + bio);

        CourseGrade grade1 = new CourseGrade(45,math,fatma);
        System.out.println("grade1 = " + grade1);

        CourseGrade grade2 = new CourseGrade(67,sdet,ahmet);
        System.out.println("grade2 = " + grade2);

        CourseGrade grade3 = new CourseGrade(78,math, ali);
        System.out.println("grade3 = " + grade3);


    }
}