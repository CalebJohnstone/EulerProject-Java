public class Main {
    /*public static int getCollatzLength(int n){
        if(n == 1){
            return 1;
        }
        else{
            //System.out.println((n % 2 == 0) ? (int) (n/2) : 3*n+1);

            //return 0;
            return 1+getCollatzLength((n % 2 == 0) ? (int) (n/2) : 3*n+1);
        }        
    }*/

    public static int getCollatzLength(Long n){
        Long x = n;
        int runLength = 1;

        while(x > 1){
            x = (x % 2 == 0) ? (Long) (x/2) : 3*x+1;
            runLength++;
        }

        return runLength;
    }

    public static void main(String[] args){
        int maxLength = 0;
        Long maxStart = 0L;

        for(Long i = 0L; i < 1000000L; i++){
            int length = Main.getCollatzLength(i);

            if(length > maxLength){
                maxLength = length;
                maxStart = i;

                System.out.println("MaxLength: " + maxLength);
                System.out.println("MaxStart: " + maxStart);
                System.out.println();
            }
        }

        System.out.println("MaxLength: " + maxLength);
        System.out.println("MaxStart: " + maxStart);
    }
}