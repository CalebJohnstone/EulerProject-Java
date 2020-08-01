import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        BigInteger number = BigInteger.valueOf(2);
        number = number.pow(1000);

        int sum = 0;
        String n = number.toString(10);

        for(int i = 0; i < n.length(); i++){
            sum += Integer.parseInt(n.charAt(i) + "");
        }

        System.out.println(n);
        System.out.println();
        System.out.println("sum: " + sum);
    }
}