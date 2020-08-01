import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        int upperbound = 2540160;
        int sum = 0;

        for(int i = 10; i <= upperbound; i++){
            //calculate sum of factorials
            int factorialSum = 0;

            int num = i;
            int digit = i;

            while(num > 0){
                digit = num % 10;
                num = (int)(num/10);                

                factorialSum += factorials[digit];
            }

            if(factorialSum == i){
                sum += factorialSum;
            }
        }

        System.out.println("Sum: " + sum);
    }
}