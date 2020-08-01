import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static int getTriangleNumber(int n){
        return (int)(0.5 * n * (n + 1));
    }

    public static boolean isPentagonal(double n){
        double a = (Math.sqrt(1+24*n) + 1.0)/6.0;

        return (a == ((int)a));
    }

    public static boolean isHexagonal(double n){
        double a = (Math.sqrt(1+8*n) + 1.0)/4.0;

        return (a == ((int)a));
    }

    public static void main(String[] args){
        //next match after n = 285
        for(int n = 286; ; n++){
            int Tn = getTriangleNumber(n);

            if(isPentagonal(Tn) && isHexagonal(Tn)){
                System.out.println(Tn);
                break;
            }
        }
    }
}