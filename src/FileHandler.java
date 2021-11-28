import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHandler {
    public static List<String> readFile(String filename){
        try{
            Path dataPath = FileSystems.getDefault().getPath(filename);
            List<String> allLines = Files.readAllLines(dataPath);
            return allLines;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean writeToFile(String filename, @NotNull String newLine, boolean append){
        if (!newLine.endsWith("\n")){
            newLine+="\n";
        }
        try{
            Path dataPath = FileSystems.getDefault().getPath(filename);
            if(append){Files.writeString(dataPath, newLine, StandardOpenOption.APPEND);}
            else{Files.writeString(dataPath, newLine);}
            System.out.println("New Line: "+newLine+" added successfully.");
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
