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
        Long number = 600851475143L;
        Long primeFactor = 0L;

        for(Long i = 3L; i <= Math.sqrt(number); i++){
            if(number % i == 0 && Main.isPrime(i)){
                primeFactor = i;
            }
        }

        System.out.println("Largest prime factor: " + primeFactor);
    }
}