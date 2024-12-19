import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public MainFrame() {
        setTitle("Education Management System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(4, 1));

        JButton addStudentButton = new JButton("Add Student");
        JButton addTeacherButton = new JButton("Add Teacher");
        JButton addCourseButton = new JButton("Add Course");
        JButton takeCourseButton = new JButton("Take Course");

        menuPanel.add(addStudentButton);
        menuPanel.add(addTeacherButton);
        menuPanel.add(addCourseButton);
        menuPanel.add(takeCourseButton);

        add(menuPanel, BorderLayout.WEST);

        // Info display area
        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);

        // Button actions
        addStudentButton.addActionListener(e -> showStudentForm(infoArea));
        addTeacherButton.addActionListener(e -> showTeacherForm(infoArea));
        addCourseButton.addActionListener(e -> showCourseForm(infoArea));
        takeCourseButton.addActionListener(e -> takeCourse(infoArea));
    }

    private void showStudentForm(JTextArea infoArea) {
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField coursesField = new JTextField();

        Object[] fields = {
                "Name:", nameField,
                "Age:", ageField,
                "Courses (comma-separated):", coursesField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String[] courseNames = coursesField.getText().split(",");
            List<Course> enrolledCourses = new ArrayList<>();
            for (String courseName : courseNames) {
                courses.stream()
                        .filter(c -> c.name.equals(courseName.trim()))
                        .findFirst()
                        .ifPresent(enrolledCourses::add);
            }
            Student student = new Student(name, age, enrolledCourses);
            students.add(student);
            infoArea.append("Added Student: " + student + "\n");
        }
    }

    private void showTeacherForm(JTextArea infoArea) {
        JTextField nameField = new JTextField();
        JTextField categoryField = new JTextField();

        Object[] fields = {
                "Name:", nameField,
                "Category:", categoryField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Teacher", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String category = categoryField.getText();
            Teacher teacher = new Teacher(name, category);
            teachers.add(teacher);
            infoArea.append("Added Teacher: " + teacher + "\n");
        }
    }

    private void showCourseForm(JTextArea infoArea) {
        JTextField nameField = new JTextField();
        JTextField categoryField = new JTextField();

        Object[] fields = {
                "Course Name:", nameField,
                "Category:", categoryField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Add Course", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String category = categoryField.getText();
            Course course = new Course(name, category);
            courses.add(course);
            infoArea.append("Added Course: " + course + "\n");
        }
    }

    private void takeCourse(JTextArea infoArea) {
        if (students.isEmpty() || courses.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Add students and courses before assigning!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Student selection
        String[] studentNames = students.stream().map(student -> student.name).toArray(String[]::new);
        String selectedStudent = (String) JOptionPane.showInputDialog(
                this,
                "Select a Student:",
                "Take Course",
                JOptionPane.PLAIN_MESSAGE,
                null,
                studentNames,
                studentNames[0]);

        if (selectedStudent == null) return; // Cancelled

        // Find selected student
        Student student = students.stream().filter(s -> s.name.equals(selectedStudent)).findFirst().orElse(null);

        // Course selection
        String[] courseNames = courses.stream().map(course -> course.name).toArray(String[]::new);
        String selectedCourse = (String) JOptionPane.showInputDialog(
                this,
                "Select a Course:",
                "Take Course",
                JOptionPane.PLAIN_MESSAGE,
                null,
                courseNames,
                courseNames[0]);

        if (selectedCourse == null) return; // Cancelled

        // Find selected course
        Course course = courses.stream().filter(c -> c.name.equals(selectedCourse)).findFirst().orElse(null);

        // Assign course to student
        if (student != null && course != null) {
            if (!student.courseList.contains(course)) {
                student.courseList.add(course);
                infoArea.append("Student " + student.name + " has taken the course: " + course.name + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Student is already enrolled in this course.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
