import java.util.*;
class Faculty {
    private String name;
    public Faculty(String name) {
        this.name = name;
    }
    public void display() {
        System.out.println("Faculty: " + name);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter university name: ");
        String uniName = sc.nextLine();
        System.out.print("Enter number of departments: ");
        int deptCount = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of faculty members: ");
        int facultyCount = sc.nextInt();
        sc.nextLine();
        University u = new University(uniName, deptCount, facultyCount);
        for (int i = 0; i < deptCount; i++) {
            System.out.print("Enter name of department " + (i + 1) + ": ");
            String deptName = sc.nextLine();
            System.out.print("Enter number of courses for " + deptName + ": ");
            int courseCount = sc.nextInt();
            sc.nextLine();
            Dept d = new Dept(deptName, courseCount);
            for (int j = 0; j < courseCount; j++) {
                System.out.print("Enter course " + (j + 1) + ": ");
                String course = sc.nextLine();
                d.addCourse(course);
            }
            u.addDepartment(d);
        }
        for (int i = 0; i < facultyCount; i++) {
            System.out.print("Enter name of faculty " + (i + 1) + ": ");
            String facultyName = sc.nextLine();
            Faculty f = new Faculty(facultyName);
            u.addFaculty(f);
        }
        u.display();
    }
}
class Dept {
    private String name;
    private String[] courses;
    private int courseCount;
    public Dept(String name, int maxCourses) {
        this.name = name;
        this.courses = new String[maxCourses];
        this.courseCount = 0;
    }
    public void addCourse(String course) {
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
        } else {
            System.out.println("Cannot add more courses.");
        }
    }
    public void display() {
        System.out.println("Department: " + name);
        System.out.print("Courses: ");
        for (int i = 0; i < courseCount; i++) {
            System.out.print(courses[i]);
            if (i < courseCount - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
class University {
    private String name;
    private Dept[] departments;
    private int deptCount;
    private Faculty[] faculties;
    private int facultyCount;
    public University(String name, int maxDepts, int maxFaculties) {
        this.name = name;
        departments = new Dept[maxDepts];
        faculties = new Faculty[maxFaculties];
        deptCount = 0;
        facultyCount = 0;
    }
    public void addDepartment(Dept d) {
        if (deptCount < departments.length) {
            departments[deptCount++] = d;
        } else {
            System.out.println("Cannot add more departments.");
        }
    }
    public void addFaculty(Faculty f) {
        if (facultyCount < faculties.length) {
            faculties[facultyCount++] = f;
        } else {
            System.out.println("Cannot add more faculties.");
        }
    }
    public void display() {
        System.out.println("\nUniversity: " + name);
        System.out.println("\nDepartments:");
        for (int i = 0; i < deptCount; i++) {
            departments[i].display();
        }
        System.out.println("\nFaculties:");
        for (int i = 0; i < facultyCount; i++) {
            faculties[i].display();
        }
    }
}