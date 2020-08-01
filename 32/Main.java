import java.util.*;
import java.math.*;

public class Main {
    public static boolean hasUniqueDigits(String x){
        if(x.contains("0")){
            return false;
        }

        Set<Character> set = new HashSet<>();
        char[] characters = x.toCharArray();

        for(Character c : characters){
            if(!set.add(c)){
                return false;
            }
        }

        return true;
    }

    public static boolean validCombo(Long a, Long b){
        //unique digits
        if(!Main.hasUniqueDigits(Long.toString(a)) || !Main.hasUniqueDigits(Long.toString(b))){
            return false;
        }    

        //mutually exclusive
        String combinedSet = Long.toString(a) + Long.toString(b);

        if(!Main.hasUniqueDigits(combinedSet)){
            return false;
        }

        //product has unique digits
        Long product = a*b;

        if(!Main.hasUniqueDigits(Long.toString(product))){
            return false;
        }

        //product is mutually exclusive to a and b
        combinedSet += Long.toString(product);

        if(!Main.hasUniqueDigits(combinedSet)){
            return false;
        }

        //total length is 9
        return (combinedSet.length() == 9);
    }

    public static void main(String[] args){
        BigInteger sum = BigInteger.valueOf(0);
        int x = 9876;

        List<BigInteger> products = new ArrayList<BigInteger>();

        for(Long a = 2L; a <= x; a++){
            for(Long b = a+1; b <= x; b++){
                BigInteger c = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b));

                if(!products.contains(c) && Main.validCombo(a,b)){                   
                    sum = sum.add(c);
                    System.out.println("Sum: " + sum + ", a = " + a  + ", b = " + b + ", c = " + c);

                    products.add(c);
                }                
            }
        }
    }
}