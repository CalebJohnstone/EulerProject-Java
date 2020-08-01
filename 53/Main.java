import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static BigInteger getFactorial(int n){
        BigInteger factorial = BigInteger.valueOf(2);

        for(int i = 3; i <= n; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    public static void main(String[] args){
        int count = 0;

        List<BigInteger> factorials = new ArrayList<BigInteger>();

        try{
			//use scanner to read in the text file
			File file = new File("output.txt");
			Scanner sc;
            sc = new Scanner(file);

            while(sc.hasNextLine()){                
                factorials.add(new BigInteger(sc.nextLine()));
            }

            //implement the actual solution
            for(int n = 23; n <= 100; n++){
                for(int r = 0; r <= n; r++){
                    BigInteger choose = factorials.get(n).divide(factorials.get(r).multiply(factorials.get(n-r)));

                    if(choose.compareTo(BigInteger.valueOf(1000000)) > 0){
                        count++;                        
                    }                    
                }
            }

            System.out.println("count: " + count);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}