public class Main {
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        int temp;

        int sum = 0;
        
        while(b < 4000000){
            //if even add to sum
            if(b % 2 == 0){
                sum += b;
            }

            //update values
            temp = a;//1
            a = b;//2
            b += temp;//3
        }

        System.out.println("Sum: " + sum);
    }
}