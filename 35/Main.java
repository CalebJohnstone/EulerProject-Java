import java.util.*;
import java.math.*;

public class Main {
    public static boolean isPrime(int x){
        if(x <= 1){
            return false;
        }

        for(int i = 2; i <= Math.floor(Math.sqrt(x)); i++){
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }

    public static boolean isCircularPrime(int x){
        String number = Integer.toString(x);

        for(int i = 0; i < number.length(); i++){
            String newNumber = number.substring(1) + number.charAt(0);
            number = newNumber;

            if(!Main.isPrime(Integer.parseInt(number))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int count = 13;

        for(int i = 101; i < 1000000; i++){
            if(Main.isCircularPrime(i)){
                count++;
            }
        }

        System.out.println("Count: " + count);
    }
}