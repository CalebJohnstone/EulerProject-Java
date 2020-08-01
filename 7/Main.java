public class Main {
    public static boolean isPrime(Long x){
        for(Long i = 2L; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int currentPrime = 0;
        Long i = 2L;

        for(;currentPrime < 10001; i++){
            if(Main.isPrime(i)){
                currentPrime++;
            }
        }

        System.out.println("10 001st prime: " + (i-1));
    }
}