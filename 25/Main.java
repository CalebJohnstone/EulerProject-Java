import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);

        int index = 2;
        int numDigits = 0;

        while(numDigits < 1000){
            index++;

            BigInteger temp = a;
            a = b;
            b = b.add(temp);

            //count the number of digits
            String bString = b.toString(10);
            numDigits = bString.length();
        }

        System.out.println("Index: "+ index);
    }
}