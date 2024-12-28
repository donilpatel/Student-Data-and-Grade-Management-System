import java.io.IOException;
import java.util.*;

public class Main {
    // helper method to ensure input files exist before proceeding
    public static void validateFilesExistence(List<String> filePaths) throws IOException {
        List<String> missingFiles = new ArrayList<>();

        for (String filePath : filePaths) {
            java.io.File file = new java.io.File(filePath);
            if (!file.exists() || file.isDirectory()) { // check if file doesn't exist or is a directory
                missingFiles.add(filePath);
            }
        }

        if (!missingFiles.isEmpty()) { // throw error if any files are missing
            throw new IOException("The following file(s) are missing: " + String.join(", ", missingFiles));
        }
    }

    // main function to execute the program
    public static void main(String[] args) {
        String nameFile = "namefile.txt"; // file containing student IDs and names
        String courseFile = "coursefile.txt"; // file containing course information
        String outputFile = "output.txt"; // file to save the output

        try {
            // validate the input files
            validateFilesExistence(Arrays.asList(nameFile, courseFile));

            // read the student and course files
            Map<String, Student> studentHashMap = File.readNameFile(nameFile);
            File.readCourseFile(courseFile, studentHashMap);

            // sort the students by ID
            List<Student> sortedStudents = new ArrayList<>(studentHashMap.values());
            sortedStudents.sort(Comparator.comparing(Student::getId));

            // write the output to a file
            File.writeOutputFile(outputFile, sortedStudents);
            System.out.println("Output written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage()); // handle file-related errors
        }
    }
}
