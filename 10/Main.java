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
        Long sum = 0L;

        for(Long i = 2L; i < 2000000; i++){
            if(Main.isPrime(i)){
                sum += i;
            }
        }

        System.out.println("Sum: " + sum);
    }
}