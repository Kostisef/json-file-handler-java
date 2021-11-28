import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JSONHandler {
    public static boolean writeStudentsJSON(String filename, List<Student> studentList){
        JSONObject studentJSON;
        JSONArray studentArray = new JSONArray();
        for (Student s : studentList){
            studentJSON = new JSONObject();
            studentJSON.put("Name", s.getName());
            studentJSON.put("Age", s.getAge());
            studentJSON.put("Courses", s.getCourses());
            studentArray.put(studentJSON);
        }

        JSONObject outer = new JSONObject();
        outer.put("STUDENTS", studentArray);

        try (FileWriter file = new FileWriter(filename)) {
            file.write(outer.toString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static List<Student> readStudentsJSON(String filename){
        try{
            Path dataPath = FileSystems.getDefault().getPath(filename);
            String content = new String(Files.readAllBytes(dataPath));
            JSONObject jsonObject = new JSONObject(content);

            JSONArray studentList = (JSONArray) jsonObject.get("STUDENTS");
            List<Student> allStudents = new ArrayList<>();


            for (int i=0;i< studentList.length();i++){
                JSONObject currentStudent = studentList.getJSONObject(i);
                String name = currentStudent.getString("Name");
                int age = currentStudent.getInt("Age");

                // loop array
                JSONArray courses = currentStudent.getJSONArray("Courses");
                List<String> coursesList = new ArrayList<>();
                for (int j=0;j<courses.length();j++){
                    coursesList.add(courses.getString(j));
                }
                Student s = new Student(name, age, coursesList);
                allStudents.add(s);
                System.out.println(name+" (age: "+age+")\t"+coursesList);


//                ~~~~~  2nd way: Use iterator to access the courses ~~~~~~
//                Iterator<Object> iterator = courses.iterator();
//                while (iterator.hasNext()) {
//                    System.out.println(iterator.next());
//                }
//                ~~~~~  2nd way: END  ~~~~~~
            }
            return allStudents;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
