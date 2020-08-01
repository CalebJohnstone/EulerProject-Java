public class Main {
    public static void main(String[] args){
        Long triangleSum = 0L;
        Long n = 0L;

        while(true){
            //calculate nth triangle number
            triangleSum += ++n;

            //count the number of divisors
            Long numDivisors = 1L;

            for(Long i = 2L; i <= Math.sqrt(triangleSum); i++){
                if(triangleSum % i == 0){
                    numDivisors++;
                }
            }

            numDivisors *= 2L;

            //check if a perfect square
            if(Math.sqrt(triangleSum) - Math.floor(Math.sqrt(triangleSum)) == 0){
                numDivisors--;//only count the sqrt once as a factor
            }

            if(numDivisors > 500){
                System.out.println("Value: " + triangleSum + ", (n = " + n + ", numDivisors = " + numDivisors + ")");
                break;
            }
        }
    }
}