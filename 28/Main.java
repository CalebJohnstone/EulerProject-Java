import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        //x-square
        int x = 1001;//1001
        int layers = (int)(x-1)/2;

        BigInteger sum = BigInteger.valueOf(1);
        BigInteger add = BigInteger.valueOf(1);

        for(int layer = 1; layer <= layers; layer++){
            for(int j = 0; j < 4; j++){
                add = add.add(BigInteger.valueOf(2*layer));
                sum = sum.add(add);

                System.out.println("Sum: " + sum);
            }
        }

        System.out.println();
        System.out.println("Sum: " + sum);
    }
}