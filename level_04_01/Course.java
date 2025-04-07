import java.util.*;
class Course {
    private String courseName;
    private Student[] enrolledStudents;
    private int studentCount;
    public Course(String courseName, int maxStudents) {
        this.courseName = courseName;
        this.enrolledStudents = new Student[maxStudents];
        this.studentCount = 0;
    }
    public String getCourseName() {
        return courseName;
    }
    public void enrollStudent(Student student) {
        if (studentCount < enrolledStudents.length) {
            enrolledStudents[studentCount++] = student;
        }
    }
    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("- " + enrolledStudents[i].getName());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();
        sc.nextLine();
        School school = new School("Sunrise High School", numStudents);
        Student[] allStudents = new Student[numStudents];
        Course[] allCourses = new Course[numCourses];
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String studentName = sc.nextLine();
            Student student = new Student(studentName, numCourses);
            school.addStudent(student);
            allStudents[i] = student;
        }
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course name: ");
            String courseName = sc.nextLine();
            Course course = new Course(courseName, numStudents);
            allCourses[i] = course;
        }
        for (int i = 0; i < numStudents; i++) {
            Student student = allStudents[i];
            System.out.println("Enroll courses for " + student.getName());
            System.out.print("How many courses to enroll? ");
            int c = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < c; j++) {
                System.out.print("Enter course name: ");
                String cname = sc.nextLine();
                for (int k = 0; k < numCourses; k++) {
                    if (allCourses[k].getCourseName().equalsIgnoreCase(cname)) {
                        student.enrollInCourse(allCourses[k]);
                        break;
                    }
                }
            }
        }
        System.out.println();
        school.showAllStudents();
        System.out.println();
        for (int i = 0; i < numStudents; i++) {
            allStudents[i].showCourses();
        }
        System.out.println();
        for (int i = 0; i < numCourses; i++) {
            allCourses[i].showEnrolledStudents();
        }
    }
}
class Student {
    private String name;
    private Course[] courses;
    private int courseCount;
    public Student(String name, int maxCourses) {
        this.name = name;
        this.courses = new Course[maxCourses];
        this.courseCount = 0;
    }
    public String getName() {
        return name;
    }
    public void enrollInCourse(Course course) {
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
            course.enrollStudent(this);
        }
    }
    public void showCourses() {
        System.out.println("Courses for " + name + ":");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("- " + courses[i].getCourseName());
        }
    }
}
class School {
    private String schoolName;
    private Student[] students;
    private int studentCount;

    public School(String schoolName, int maxStudents) {
        this.schoolName = schoolName;
        this.students = new Student[maxStudents];
        this.studentCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        }
    }

    public void showAllStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("- " + students[i].getName());
        }
    }
    public Student[] getStudents() {
        return Arrays.copyOf(students, studentCount);
    }
}