import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static boolean isPrime(BigInteger x){
        if(x.compareTo(BigInteger.valueOf(1)) <= 0){
            return false;
        }

        for(BigInteger i = BigInteger.valueOf(2); i.compareTo(x.sqrt()) <= 0; i = i.add(BigInteger.valueOf(1))){
            if(x.mod(i).compareTo(BigInteger.valueOf(0)) == 0){
                return false;
            }
        }

        return true;
    }

    public static boolean canWriteAsSum(BigInteger n){
        for(BigInteger s = BigInteger.valueOf(1); s.compareTo(n.subtract(BigInteger.valueOf(2))) < 0 ; s = s.add(BigInteger.valueOf(1))){
            BigInteger twiceSquare = s.pow(2).multiply(BigInteger.valueOf(2));
            BigInteger difference = n.subtract(twiceSquare);

            if(isPrime(difference)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        //largest given example that does fit is 33
        for(BigInteger n = BigInteger.valueOf(35); ; n = n.add(BigInteger.valueOf(2))){
            if(!isPrime(n) && !canWriteAsSum(n)){
                System.out.println(n);
                break;
            }
        }
    }
}