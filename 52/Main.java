import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        BigInteger x = BigInteger.valueOf(10);

        while(true){
            char[] xChars = x.toString(10).toCharArray();
            Arrays.sort(xChars);

            boolean correct = true;

            for(int times = 2; times <= 6 && correct; times++){
                char[] multipleChars = x.multiply(BigInteger.valueOf(times)).toString(10).toCharArray();
    
                if(xChars.length == multipleChars.length){
                    //sort                    
                    Arrays.sort(multipleChars);
    
                    //check each character for equality
                    for(int i = 0; i < xChars.length; i++){
                        if(xChars[i] != multipleChars[i]){
                            correct = false;
                            break;
                        }
                    }

                    if(correct){
                        System.out.println(x + ", times =  " + times);
                    }
                }
                else{
                    correct = false;
                    break;
                }
            }

            if(correct){
                System.out.println(x);
                break;
            }
            
            x = x.add(BigInteger.valueOf(1));
        }
    }
}