import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        int maxNumSolutions = 0;
        int maxP = 0;

        int x = 12;//12
        int y = 1000;//1000

        for(int p = x; p <= y; p++){
            int numSolutions = 0;

            for(int a = 1; a <= 998; a++){
                for(int b = a+1; b <= 998 && a+b < p; b++){
                    int lhs = a*a + b*b;

                    int rhs = (p-(a+b))*(p-(a+b));

                    if(lhs == rhs){
                        System.out.println("a = " + a + ", b = " + b + ", c = " + (p-(a+b)));
                        numSolutions++;
                    }
                }
            }

            System.out.println("p = " + p + ", numSolutions = " + numSolutions);

            if(numSolutions > maxNumSolutions){
                maxNumSolutions = numSolutions;
                maxP = p;
            }
        }

        System.out.println("maxP: " + maxP + ", maxNumSolutions = " + maxNumSolutions);
    }
}