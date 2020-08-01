public class Main {
    public static boolean isAbundant(int x){
        int sum = 1;

        if(Math.floor(Math.sqrt(x)) - Math.sqrt(x) == 0){
            sum -= Math.floor(Math.sqrt(x));
        }

        for(int i = 2; i <= Math.floor(Math.sqrt(x)) && sum <= x; i++){
            if(x % i == 0){
                sum += i + (int)(x/i);
            }
        }

        return (sum > x);
    }

    public static boolean noAbundantCombination(int x, int[] abundantNumbers, int count){
        for(int i = 0; i < count && abundantNumbers[i] < x; i++){
            for(int j = i; j < count; j++){
                if((abundantNumbers[i] + abundantNumbers[j]) == x){
                    return false;//found a combination
                }
                else if((abundantNumbers[i] + abundantNumbers[j]) > x){
                    break;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] abundantNumbers = new int[28123];
        abundantNumbers[0] = 12;

        int abundantNumberCount = 1;

        for(int i = 13; i <= 28123; i++){
            if(Main.isAbundant(i)){
                abundantNumbers[abundantNumberCount++] = i; 
            }
        }

        //print the abundant numbers
        /*for(int i = 0; i < abundantNumberCount; i++){
            System.out.println((i+1) + ": " + abundantNumbers[i]);
        }*/

        int sum = 276;

        for(int i = 25; i <= 28123; i++){
            if(Main.noAbundantCombination(i, abundantNumbers, abundantNumberCount)){
                sum += i;
            }
        }

        System.out.println("Sum: " + sum);
    };
}