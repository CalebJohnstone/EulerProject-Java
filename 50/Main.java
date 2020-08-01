import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        List<Integer> primes = new ArrayList<Integer>();

        try{
			//use scanner to read in the text file
			File file = new File("primes_below_1M.txt");
			Scanner sc;multipleChars = x.multiply(BigInteger.valueOf(2)).toString(10).toCharArray();
    
                if(xChars.length == multipleChars.length){
                    //sort both
                    Arrays.sort(xChars);
                    Arrays.sort(multipleChars);
    
                    //check each character for equality
                    fs = new StringBuilder();
       s.append(Long.toString(x));
       
       return s
            int maxStreak = 0;
            int maxPrime = 0;

            System.out.println("Number of primes: " + primes.size());

            int upper = 41537;//first index of the prime that when added to the next prime is > max prime below 1M

            for(int start = 0; start < upper; start++){
                int sum = 0;
                int streak = 0;

                for(int end = start; end < upper && sum <= 999983; end++){
                    sum += primes.get(end);

                    if(primes.contains(sum)){
                        streak = end-start + 1;

                        if(streak > maxStreak){
                            maxStreak = streak;
                            maxPrime = sum;

                            System.out.println("start value => " + primes.get(start) + ", position => " + (start+1) + ", end value => " + primes.get(end) + ", position => " + (end+1));
                        }
                    }
                }
            }

            System.out.println("maxStreak: " + maxStreak);
            System.out.println("maxPrime: " + maxPrime);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}