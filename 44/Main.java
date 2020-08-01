import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static int getPValue(int n){
        return (int)(0.5 * n * (3*n - 1));
    }

    public static boolean isPentagonal(double n){
        double a = (Math.sqrt(1+24*n) + 1.0)/6.0;

        return (a == ((int)a));
    }

    public static int find(){
        int j = 1;

        while(true){
            j++;

            int Pj = getPValue(j);

            for(int k = j-1; k > 0; k--){
                int Pk = getPValue(k);

                if(isPentagonal(Pj+Pk) && isPentagonal(Math.abs(Pk-Pj))){
                    return Math.abs(Pk-Pj);
                }
            }
        }
    }

    public static void main(String[] args){
        int D = Main.find();
        System.out.println("D: " + D);
    }
}