import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        String d = ".";
        int n = 1;

        int x = 1000001;//1000001

        while(d.length() <= x){
            d += Integer.toString(n++);
        }

        System.out.println(d + ", length = " + d.length());

        BigInteger s = new BigInteger(d.charAt(1) + "");
        System.out.println("s = " + s);

        for(int i = 1; i <= 6; i++){
            System.out.println("s = " + s);
            System.out.println("10**i: " + (int)(Math.pow(10,i)));
            System.out.println(d.charAt((int)(Math.pow(10,i))));

            s = s.multiply(BigInteger.valueOf(Integer.parseInt(d.charAt((int)(Math.pow(10,i))) + "")));
            System.out.println("s = " + s);
        }

        System.out.println("s = " + s);
    }
}