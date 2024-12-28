// this class implements the GradedEntity interface to ensure all courses can calculate grades and provide a code
public class Course implements GradedEntity {
    // private final fields for course code and test scores
    private final String courseCode;
    private final double test1;
    private final double test2;
    private final double test3;
    private final double finalExam;

    // constructor initializes the course code and test scores
    public Course(String courseCode, double test1, double test2, double test3, double finalExam) {
        this.courseCode = courseCode; // unique identifier for the course
        this.test1 = test1; // marks for test 1
        this.test2 = test2; // marks for test 2
        this.test3 = test3; // marks for test 3
        this.finalExam = finalExam; // marks for the final exam
    }

    // this method provides the course code (implements the GradedEntity interface)
    @Override
    public String getCode() {
        return courseCode;
    }

    // calculates the final grade based on weighted averages
    @Override
    public double calculateFinalGrade() {
        return (test1 * 0.2) + (test2 * 0.2) + (test3 * 0.2) + (finalExam * 0.4); // weighted grades
    }
}