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

    public static String maxPandigital(){
        for(int i = 9876; i > 192; i--){
            int n = 2;
            String concatenatedProduct = Integer.toString(i);

            while(Main.hasUniqueDigits(concatenatedProduct) && concatenatedProduct.length() < 9){
                Long product = (long) n++*i;

                concatenatedProduct += Long.toString(product);
            }

            if(Main.hasUniqueDigits(concatenatedProduct) && concatenatedProduct.length() == 9){
                System.out.println("i = " + i);
                return concatenatedProduct;
            }
        }

        return "";
    }

    public static void main(String[] args){
        String s = Main.maxPandigital();
        System.out.println("maxPandigital: " + s);
    }
}