import java.math.BigInteger;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        //100!
        BigInteger product = BigInteger.valueOf(1);

        for(int i = 99; i > 1; i--){
            if(i % 10 != 0){
                product = product.multiply(BigInteger.valueOf(i));
            }
            else{
                product = product.multiply(BigInteger.valueOf(i/10));
            }

            while(product.mod(BigInteger.valueOf(10)) == BigInteger.valueOf(0)){
                product = product.divide(BigInteger.valueOf(10));
            }

            System.out.println("product: " + product);
        }

        System.out.println("product: " + product);

        //add digits
        String p = product.toString(10);
        int sum = 0;

        for(int i = 0; i < p.length(); i++){
            sum += Integer.parseInt(p.charAt(i) + "");
        }

        System.out.println("Sum: " + sum);
    }
}