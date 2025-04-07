import java.util.Scanner;
class Course {
    protected String courseName;
    protected int duration;
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public String getCourseDetails() {
        return "Course: " + courseName + " | Duration: " + duration + " weeks";
    }
    public void displayCourseInfo() {
        System.out.println(getCourseDetails());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Duration (weeks): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Platform: ");
        String platform = scanner.nextLine();
        System.out.print("Is the course recorded? (true/false): ");
        boolean isRecorded = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Enter Course Fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter Discount (%): ");
        double discount = scanner.nextDouble();
        Course course = new PaidOnlineCourse(courseName, duration, platform, isRecorded, fee, discount);
        System.out.println("\nCourse Details:");
        course.displayCourseInfo();
    }
}
class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    @Override
    public String getCourseDetails() {
        return super.getCourseDetails() + " | Platform: " + platform + " | Recorded: " + isRecorded;
    }
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    @Override
    public String getCourseDetails() {
        return super.getCourseDetails() + " | Fee: $" + fee + " | Discount: " + discount + "%";
    }
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}