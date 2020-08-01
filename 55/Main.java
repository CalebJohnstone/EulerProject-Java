import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static boolean isPalindrome(BigInteger x){
        //convert to string
        String number = x.toString(10);

        for(int i = 0; i < number.length()/2; i++){
            if(number.charAt(i) != number.charAt(number.length()-1-i)){
                return false;
            }
        }

        return true;
    }

    public static BigInteger reverse(BigInteger x){
       StringBuilder s = new StringBuilder();
       s.append(x.toString(10));

       return new BigInteger(s.reverse().toString());
    } 

    public static boolean isLychrelNumber(int n){
        int iterations = 0;
        BigInteger current = BigInteger.valueOf(n);

        while(iterations < 50){
            if(isPalindrome(current) && iterations > 0){
                //System.out.println(iterations);
                return false;
            }
            else{
                //System.out.println(current);

                current = current.add(reverse(current));
                iterations++;
            }
        }

        System.out.println("n = " + n);

        return true;         
    }
    public static void main(String[] args){
        int count = 0;

        for(int n = 10; n < 10000; n++){
            if(isLychrelNumber(n)){
                count++;
                //break;//
            }
        }

        //System.out.println(isLychrelNumber(47));

        System.out.println("count: " + count);
    }
}