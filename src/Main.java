import org.jetbrains.annotations.NotNull;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        // ~~~ READ/WRITE JSON files ~~~
        boolean writeToJSON = false;
        String jsonFileName = "files/students.json";
        if(writeToJSON) {
            List<Student> sList = createStudentList();
            boolean wrJSON = JSONHandler.writeStudentsJSON(jsonFileName, sList);
            System.out.println(wrJSON);
        }
        else{
            List<Student> content = JSONHandler.readStudentsJSON(jsonFileName);
            if (content.isEmpty()){
                System.out.println("Empty...");
            }
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        // ~~~ READ/WRITE simple files ~~~
        boolean writeToFile = false;
        String simpleFileName = "files/data.txt";
        if(writeToFile) {
            String newContent = "This is a new line created from IntelliJ!!";
            FileHandler.writeToFile(simpleFileName, newContent, true);
        }
        else{
            List<String> fileLines = FileHandler.readFile(simpleFileName);
            int counter = 1;
            for (String line: fileLines){
                System.out.println("Line "+counter+": "+line);
                counter++;
            }
        }
    }

    public static @NotNull List<Student> createStudentList(){
        List<Student> sList = new ArrayList<>();

        Student s1 = new Student("John Doe", 55, Arrays.asList("Applications of TinyML", "JavaScript", "Algorithms"));
        Student s2 = new Student("Adison Lee", 25, Arrays.asList("Introduction to Computer Science", "Big Data Systems", "Dynamic Web Applications"));
        Student s3 = new Student("Lucy Hinton", 38, Arrays.asList("Data Science: Machine Learning", "Fundamentals of TinyML", "Deploying TinyML"));

        sList.add(s1);
        sList.add(s2);
        sList.add(s3);

        return sList;
    }
}
