public class Main {
    public static void main(String[] args){
        int sumSquared = (int) Math.pow(5050,2);

        int squaredSum = 0;

        for(int i = 1; i <= 100; i++){
            squaredSum += (int) Math.pow(i,2);
        }

        int difference = squaredSum-sumSquared;
        System.out.println("Difference: " + difference);
    }
}