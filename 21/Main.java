public class Main {
    public static Long d(Long x){
        Long d = 1L;

        for(Long i = 2L; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                d += i + (int)(x/i);
            }
        }

        return d;
    }

    public static void main(String[] args){
        Long sum = 0L;

        for(Long i = 2L; i < 10000L; i++){
            Long friend = Main.d(i);
            
            if(friend.equals(i)){
                continue;
            }

            Long friendAgain = Main.d(friend);

            //test if they are amicable numbers
            if(friendAgain.equals(i)){
                sum += i;
            }
        }

        System.out.println("Sum: " + sum);
        
        System.out.println("d(220) => " + Main.d(220L));
        System.out.println("d(284) => " + Main.d(284L));
    }
}