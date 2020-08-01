public class Main {
    public static boolean isPrime(int x){
        if(x <= 1){
            return false;
        }

        for(int i = 2; i <= Math.floor(Math.sqrt(x)); i++){
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int a = 0;
        int b = 0;

        int maxStreak = 0;

        for(int i = -999; i < 1000; i++){
            for(int j = 2; j <= 1000; j++){
                if(Main.isPrime(j)){
                    int n = 1;

                    while(Main.isPrime(n*n + i*n + j)){
                        n++;
                    }
    
                    if(n > maxStreak){
                        maxStreak = n;
                        a = i;
                        b = j;
                    }
                }
            }
        }

        System.out.println("maxStreak: " + maxStreak);
        System.out.println("Product: " + (a*b));
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}