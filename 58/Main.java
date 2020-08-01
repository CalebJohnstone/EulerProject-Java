import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static boolean isPrime(BigInteger x){
        for(BigInteger i = BigInteger.valueOf(2); i.compareTo(x.sqrt()) <= 0; i = i.add(BigInteger.valueOf(1))){
            if(x.mod(i).compareTo(BigInteger.valueOf(0)) == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        BigInteger add = BigInteger.valueOf(1);
        int primeCount = 0;
        int totalDiagonalCount = 1;

        for(int layer = 1; ; layer++){
            for(int j = 0; j < 3; j++){ 
                add = add.add(BigInteger.valueOf(2*layer));

                if(isPrime(add)){
                    primeCount++;
                }
            }

            add = add.add(BigInteger.valueOf(2*layer));
            totalDiagonalCount += 4;

            double percentage = (primeCount*1.0)/(totalDiagonalCount*1.0);

            if(percentage < 0.1){
                System.out.println(1+2*layer + " (" + layer + ")");
                break;
            }
        }
    }
}