// class representing a student, which extends the Person class
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private final List<GradedEntity> gradedEntities; // list to store graded entities (courses, assignments, etc.)

    // constructor initializes the student with an ID and name
    public Student(String studentId, String studentName) {
        super(studentId, studentName); // call the parent class (Person) constructor
        this.gradedEntities = new ArrayList<>(); // initialize the list
    }

    // getter for the list of graded entities
    public List<GradedEntity> getGradedEntities() {
        return gradedEntities;
    }

    // method to add a graded entity to the list
    public void addGradedEntity(GradedEntity gradedEntity) {
        gradedEntities.add(gradedEntity);
    }
}