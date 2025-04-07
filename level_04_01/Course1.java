import java.util.*;
class Course1 {
    private String name;
    private Professor professor;
    public Course1(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void assignProfessor(Professor p) {
        this.professor = p;
    }
    public Professor getProfessor() {
        return professor;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine();
        Student1[] students = new Student1[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            students[i] = new Student1(name, 5);
        }
        System.out.print("Enter number of professors: ");
        int numProfessors = sc.nextInt();
        sc.nextLine();
        Professor[] professors = new Professor[numProfessors];
        for (int i = 0; i < numProfessors; i++) {
            System.out.print("Enter professor name: ");
            String name = sc.nextLine();
            professors[i] = new Professor(name);
        }
        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();
        sc.nextLine();
        Course1[] courses = new Course1[numCourses];
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course name: ");
            String cname = sc.nextLine();
            courses[i] = new Course1(cname);
            System.out.print("Assign professor name: ");
            String pname = sc.nextLine();
            for (Professor p : professors) {
                if (p.getName().equalsIgnoreCase(pname)) {
                    courses[i].assignProfessor(p);
                    p.addCourse(courses[i]);
                    break;
                }
            }
        }
        for (Student1 student : students) {
            System.out.println("Enroll courses for " + student.getName());
            System.out.print("How many courses to enroll? ");
            int count = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < count; i++) {
                System.out.print("Enter course name: ");
                String cname = sc.nextLine();
                for (Course1 c : courses) {
                    if (c.getName().equalsIgnoreCase(cname)) {
                        student.enrollCourse(c);
                        break;
                    }
                }
            }
        }
        System.out.println("\nUniversity Summary");
        for (Student1 student : students) {
            student.showCourses();
        }
        for (Professor prof : professors) {
            prof.showCourses();
        }
    }
}
class Student1 {
    private String name;
    private Course1[] courses;
    private int courseCount;
    public Student1(String name, int maxCourses) {
        this.name = name;
        this.courses = new Course1[maxCourses];
        this.courseCount = 0;
    }
    public String getName() {
        return name;
    }
    public void enrollCourse(Course1 c) {
        if (courseCount < courses.length) {
            courses[courseCount++] = c;
            System.out.println(name + " enrolled in " + c.getName());
        }
    }
    public void showCourses() {
        System.out.println("Courses for " + name + ":");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("- " + courses[i].getName() + " (Professor: " +
                    (courses[i].getProfessor() != null ? courses[i].getProfessor().getName() : "None") + ")");
        }
        System.out.println();
    }
}
class Professor {
    private String name;
    private Course1[] courses;
    private int courseCount;
    public Professor(String name) {
        this.name = name;
        this.courses = new Course1[5];
        this.courseCount = 0;
    }
    public String getName() {
        return name;
    }
    public void addCourse(Course1 c) {
        if (courseCount < courses.length) {
            courses[courseCount++] = c;
        }
    }
    public void showCourses() {
        System.out.println("Courses taught by Professor " + name + ":");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("- " + courses[i].getName());
        }
        System.out.println();
    }
}