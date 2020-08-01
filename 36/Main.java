import java.util.*;
import java.math.*;

public class Main {
    public static boolean isPalindrome(String number){
        for(int i = 0; i < number.length()/2; i++){
            if(number.charAt(i) != number.charAt(number.length()-1-i)){
                return false;
            }
        }

        return true;
    }

    public static boolean doubleBasePalidnrome(int x){
        if(!Main.isPalindrome(Integer.toString(x)) || !Main.isPalindrome(Integer.toBinaryString(x))){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        int sum = 0;

        for(int i = 1; i < 1000000; i++){
            if(Main.doubleBasePalidnrome(i)){
                sum += i;
            }
        }

        System.out.println("Sum: " + sum);
    }
}