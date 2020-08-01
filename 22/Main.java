import java.math.BigInteger;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int getNameScore(String name){
        int sum = 0;

        //ignore 1st and last characers which are quotes
        for(int i = 1; i < name.length()-1; i++){
            sum += ((int) name.charAt(i)) - 64;
        }

        return sum;
    }

    public static void main(String[] args){
        try{
			//use scanner to read in the text file
			File file = new File("p022_names.txt");
			Scanner sc;
            sc = new Scanner(file);

            String[] names = sc.nextLine().split(",");

            //sort the array
            Arrays.sort(names);

            //determine the score for each name and add it to the sum
            BigInteger sum = BigInteger.valueOf(0);

            for(int i = 0; i < names.length; i++){
                sum = sum.add(BigInteger.valueOf(Main.getNameScore(names[i])).multiply(BigInteger.valueOf(i+1)));
            }

            System.out.println("Sum: " + sum);

            System.out.println("Score(COLIN) => " + Main.getNameScore("COLIN"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}