import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static boolean hasUniqueDigits(String x){
        //6th digit is 5
        if(Integer.parseInt(x.charAt(6) + "") != 5){
            return false;
        }
        
        //4th digit must be even
        if(Integer.parseInt(x.charAt(3) + "") % 2 != 0){
            return false;
        }

        //check d3d4d5 divisible by 3
        if(Integer.parseInt(x, 2, 5, 10) % 3 != 0){
            return false;
        }

        for(int i = 0; i <= 9; i++){
            if(!x.contains(Integer.toString(i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] div = {7, 11, 13, 17};

        BigInteger sum = BigInteger.valueOf(0);

        for(Long x = 1023456789L; x <= 9876543210L; x++){
            if(Main.hasUniqueDigits(Long.toString(x))){
                String number = Long.toString(x);
                boolean correct = true;
    
                for(int n = 5, index = 0; n <= 8 && correct; n++, index++){
                    String substring = number.substring(n-1, n+2);
                    Long subNum = Long.parseLong(substring);
    
                    if(subNum % div[index] != 0){
                        correct = false;
                    }
                }
    
                if(correct){
                    sum = sum.add(BigInteger.valueOf(x));
                }

                //System.out.print(x + ", ");
            }
        }

        System.out.println();
        System.out.println("Sum: " + sum);
    }
}