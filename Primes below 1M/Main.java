import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        List<Integer> primes = new ArrayList<Integer>();

        try{
			//use scanner to read in the text file
			File file = new File("primes_below_1M.txt");
			Scanner sc;
            sc = new Scanner(file);

            while(sc.hasNextLine()){                
                String[] numbers = sc.nextLine().split(",");

                //add all of the numbers to the primes list
                for(int i = 0; i < numbers.length; i++){
                    primes.add(Integer.parseInt(numbers[i]));
                }
            }

            //implement the actual solution
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}