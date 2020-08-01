import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static int getNameScore(String name){
        int sum = 0;

        for(int i = 0; i < name.length(); i++){
            sum += ((int) name.charAt(i)) - 64;
        }

        return sum;
    }

    public static void main(String[] args){
        try{
			//use scanner to read in the text file
			File file = new File("p042_words.txt");
			Scanner sc;
            sc = new Scanner(file);

            String[] names = sc.nextLine().replace("\"", "").split(",");

            //previously generated these
            List<Integer> t = new ArrayList<Integer>(Arrays.asList(1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153));//maxScore = 161 (output)

            int count = 0;

            for(String name : names){
                if(t.contains(Main.getNameScore(name))){
                    count++;
                }
            }

            System.out.println("count: " + count);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}