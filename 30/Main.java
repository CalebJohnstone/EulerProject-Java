import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        BigInteger sum = BigInteger.valueOf(0);

        //find all of the numbers
        int x = 355000;//355000

        for(int i = 10; i <= x; i++){
            //for each digit
            int number = (int)(i/10);
            int digit = i % 10;

            BigInteger digitSum = BigInteger.valueOf(0);
            
            //System.out.println("i: " + i);

            while(number > 0 || digit > 0){
                digitSum = digitSum.add(BigInteger.valueOf(digit).pow(5));

                digit = number % 10;
                number /= 10;
            }

            /*System.out.println("digitSum: " + digitSum);
            System.out.println();*/

            //check sum
            if(digitSum.equals(BigInteger.valueOf(i))){
                sum = sum.add(BigInteger.valueOf(i));
            }
        }

        System.out.println("Sum: " + sum);
    }
}