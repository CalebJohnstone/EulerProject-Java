import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        BigInteger mainNumerator = BigInteger.valueOf(1);
        BigInteger mainDenominator = BigInteger.valueOf(1);        

        for(int i = 10; i < 100; i++){
            for(int j = i+1; j < 100; j++){
                if(i % 10 == 0 && j % 10 == 0){
                    continue;
                }

                double fraction = (i * 1.0)/j;

                int a = i % 10;
                int x = (int)(i/10);
                int y = j % 10;

                int z = (int)(j/10);

                if(a == z){
                    double other = (x * 1.0)/y;

                    if(other == fraction){
                        mainNumerator = mainNumerator.multiply(BigInteger.valueOf(i));
                        mainDenominator = mainDenominator.multiply(BigInteger.valueOf(j));
    
                        System.out.println("x = " + x + ", y = " + y);
                        System.out.println("i = " + i);
                        System.out.println("j = " + j);
                        System.out.println();
                    }
                }
            }
        }

        System.out.println("Main Numerator: " + mainNumerator);
        System.out.println("Main Denominator: " + mainDenominator);
    }
}