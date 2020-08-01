import java.util.*;
import java.math.*;

public class Main {
    public static boolean hasUniqueDigits(String x){
        if(x.contains("0")){
            return false;
        }

        for(int i = 1; i <= x.length(); i++){
            if(!x.contains(Integer.toString(i))){
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int x){
        for(int i = 3; i <= Math.floor(Math.sqrt(x)); i += 2){
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }

    public static int find(){
        for(int i = 987654321; i > 2; i -= 2){
            if(Main.hasUniqueDigits(Integer.toString(i)) && Main.isPrime(i)){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args){
        int answer = Main.find();
        System.out.println("answer = " + answer);
    }
}