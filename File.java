import java.io.*;
import java.util.*;

public class File {
    // reads a file containing student IDs and names and returns a map of student objects
    public static Map<String, Student> readNameFile(String filePath) throws IOException {
        Map<String, Student> studentHashMap = new HashMap<>();

        // use buffered reader to read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0; // keeps track of the line number for error reporting
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(","); // split the line by commas
                if (parts.length != 2) { // ensure the line contains exactly two items
                    throw new IOException("Invalid format in namefile.txt at line " + lineNumber);
                }

                String studentId = parts[0].trim(); // extract and clean the student ID
                String studentName = parts[1].trim(); // extract and clean the student name

                // validate the student ID to ensure it is numeric and non-negative
                try {
                    if (Long.parseLong(studentId) < 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    throw new IOException("Invalid student ID (must be numeric and non-negative) in namefile.txt at line " + lineNumber);
                }

                // create a new student object and add it to the map
                studentHashMap.put(studentId, new Student(studentId, studentName));
            }
        }

        return studentHashMap; // return the populated map
    }

    // reads a file containing course information and associates the data with existing students
    public static void readCourseFile(String filePath, Map<String, Student> studentHashMap) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0; // keeps track of the line number for error reporting
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(","); // split the line by commas
                if (parts.length != 6) { // ensure the line contains six items
                    throw new IOException("Invalid format in coursefile.txt at line " + lineNumber);
                }

                String studentId = parts[0].trim(); // student ID
                String courseCode = parts[1].trim(); // course code
                try {
                    // parse the test and exam scores
                    double test1 = Double.parseDouble(parts[2].trim());
                    double test2 = Double.parseDouble(parts[3].trim());
                    double test3 = Double.parseDouble(parts[4].trim());
                    double finalExam = Double.parseDouble(parts[5].trim());

                    // validate the scores to ensure they are within a valid range
                    if (!isValidScore(test1) || !isValidScore(test2) ||
                        !isValidScore(test3) || !isValidScore(finalExam)) {
                        throw new IOException("Invalid test scores in coursefile.txt at line " + lineNumber);
                    }

                    // if the student ID exists, add the course to the student
                    if (studentHashMap.containsKey(studentId)) {
                        Student student = studentHashMap.get(studentId);
                        student.addGradedEntity(new Course(courseCode, test1, test2, test3, finalExam));
                    }
                } catch (NumberFormatException e) {
                    throw new IOException("Invalid number format in coursefile.txt at line " + lineNumber, e);
                }
            }
        }
    }

    // writes the final output to a file
    public static void writeOutputFile(String filePath, List<Student> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (var student : students) { // loop through each student
                for (GradedEntity gradedEntity : student.getGradedEntities()) { // loop through each graded entity
                    // write student ID, name, course code, and final grade to the file
                    writer.write(String.format("%s, %s, %s, %.1f%n",
                            student.getId(),
                            student.getName(),
                            gradedEntity.getCode(),
                            gradedEntity.calculateFinalGrade()));
                }
            }
        }
    }

    // helper method to validate test scores (range: 1-100)
    private static boolean isValidScore(double score) {
        return score >= 1 && score <= 100;
    }
}