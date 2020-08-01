import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        List<BigInteger> combinations = new ArrayList<BigInteger>();
        int x = 100;//100

        for(int a = 2; a <= x; a++){
            for(int b = 2; b <= x; b++){
                BigInteger value = BigInteger.valueOf(a).pow(b);

                if(!combinations.contains(value)){
                    combinations.add(value);
                }
            }
        }

        System.out.println("Number of distinct terms: " + combinations.size());
    }
}