import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner scanner, String prompt){
        String s = "";
        do {
            System.out.print(prompt + ": ");
            s = scanner.nextLine().trim();
        }
        while(s.length() == 0);
        return s;
        
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high ){
        int val = low - 1;
        do{
            System.out.println(prompt + ": ");
            String line = pipe.nextLine().trim();
            try{
                val = Integer.parseInt(line);
            }catch (NumberFormatException e){
                val = low - 1;
            }
        }while(val<low || val>high);
        return val;
    }
    public static String getRegExString(Scanner pipe, String prompt, String pattern){
        String s = "";
        do{
            System.out.println(prompt + ":");
            s = pipe.nextLine().trim();
        }while(!s. matches(pattern));
        return s;
    }
}
