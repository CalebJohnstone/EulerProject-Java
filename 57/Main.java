import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static int getNumberOfDigits(BigInteger n){
        return n.toString(10).length();
    }
    public static void main(String[] args){
        BigInteger numerator = BigInteger.valueOf(3);
        BigInteger denominator = BigInteger.valueOf(2);

        int steps = 1000;//1000
        int count = 0;

        for(int n = 2; n <= steps; n++){            
            if(getNumberOfDigits(numerator) > getNumberOfDigits(denominator)){
                count++;
            }

            BigInteger oldNumerator = numerator;

            numerator = numerator.add(denominator.multiply(BigInteger.valueOf(2)));
            denominator = denominator.add(oldNumerator);
        }

        System.out.println(count);
    }
}