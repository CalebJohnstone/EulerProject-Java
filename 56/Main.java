import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static int getDigitSum(BigInteger n){
        String s = n.toString(10);
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            sum += Integer.parseInt(s.charAt(i) + "");
        }

        return sum;
    }
    public static void main(String[] args){
        int maxDigitSum = 0;

        for(int a = 2; a < 100; a++){
            for(int b = 2; b < 100; b++){
                int digitSum = getDigitSum(BigInteger.valueOf(a).pow(b));

                if(digitSum > maxDigitSum){
                    maxDigitSum = digitSum;
                }
            }
        }

        System.out.println(maxDigitSum);
    }
}