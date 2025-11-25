import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        boolean more = true;

        while (more){
            String first = SafeInput.getNonZeroLenString(scanner, "First Name: ");
            String last = SafeInput.getNonZeroLenString(scanner, "Last Name: ");
            String id = SafeInput.getRegExString(scanner, "6-digit ID (example 000001)", "\\d{6}");
            String email = SafeInput.getNonZeroLenString(scanner, "Email:");
            int yob = SafeInput.getRangedInt(scanner,"Year of Birth", 1900, 2025);

            String csv = String.join(
                    ", ",
                    Arrays.asList(first, last, id, email, String.valueOf(yob))
            );
            records.add(csv);
            String again = SafeInput.getRegExString(scanner, "add another record? (Y/N) ", "(?i)[YN]");
            more = again.equalsIgnoreCase("Y");
        }
        System.out.println("Enter filename (without extension): ");
        String fname = scanner.nextLine().trim();
        if (!fname.endsWith(".csv"))
            fname += ".csv";
        Path out = Paths.get("src", fname);
        try{
            Files.write(out, records);
            System.out.println("Saved" + records.size()+ "records to: " + out);
        }catch(IOException e){
            System.out.println("ERROR writing file: "+ e.getMessage());
        }
    }
}
