import javax.swing.*;
import javax.xml.transform.Source;
import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileInspector {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("src"));
            int result = chooser.showOpenDialog(null);
            if(result != JFileChooser.APPROVE_OPTION){
                System.out.println("No file chosen. Exiting. ");
                return;

            }
            File file = chooser.getSelectedFile();
            Path path = file.toPath();

            long lineCount = 0;
            long wordCount= 0;
            long charCount = 0;

            System.out.println("---File Contents---");
            try (BufferedReader br = Files.newBufferedReader(path)){
                String line;
                while ((line = br.readLine()) != null){
                    System.out.println(line);
                    lineCount++;
                    if (!line.trim().isEmpty()){
                        String[] words = line.trim().split("\\s+");
                        wordCount += words.length;
                    }
                    charCount += line.length();
                }
            }
            catch (IOException e){
                System.err.println("Error reading File: " + e.getMessage());
                return;
            }
            System.out.println("\n ---- Summary Report ---- ");
            System.out.println("File: " + file.getName());
            System.out.println("Lines: " + lineCount);
            System.out.println("Characters: " + charCount);
        });
    }
}
