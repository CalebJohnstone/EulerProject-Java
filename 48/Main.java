import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        int x = 1000;
        BigInteger sum = BigInteger.valueOf(0);

        for(int i = 1; i <= x; i++){
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }

        System.out.println("sum = " + sum);

        String s = sum.toString(10);
        String lastTen = s.substring(s.length()-10);
        System.out.println("lastTen = " + lastTen);
    }
}