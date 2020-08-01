import java.util.*;
import java.math.*;

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

    public static boolean isTruncatablePrime(BigInteger x){
        String number = x.toString(10);

        while(number.length() > 1){  
            if(Main.isPrime(new BigInteger(number))){
                number = number.substring(1);
            }
            else{
                return false;
            }            
        }

        if(!Main.isPrime(new BigInteger(number))){
            return false;
        }

        number = x.toString(10);

        while(number.length() > 1){   
            if(Main.isPrime(new BigInteger(number))){
                number = number.substring(0, number.length()-1);
            }
            else{
                return false;
            }  
        }

        if(!Main.isPrime(new BigInteger(number))){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        int count = 0;
        BigInteger sum = BigInteger.valueOf(0);
        
        for(BigInteger i = BigInteger.valueOf(11); count < 11; i = i.add(BigInteger.valueOf(1))){
            if(Main.isTruncatablePrime(i)){
                sum = sum.add(i);
                count++;
            }
        }

        System.out.println("Sum: " + sum);
    }
}