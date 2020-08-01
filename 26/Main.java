import java.util.*;

public class Main {
    public static int getNumberRepeats(int x){
        List<Integer> remainders = new ArrayList<Integer>();
        List<Integer> counts = new ArrayList<Integer>();

        int a = 10;
        int q = 2;

        while(true){
            //divide
            int div = (int)(a/x);

            //multiply
            int mult = div*x;

            //subtract
            int sub = a-mult;

            //bring down
            a = 10*sub;

            if(a == 0){
                return 0;//terminates
            }

            //check if this remainder is repeating
            if(remainders.contains(a)){
                int index = 0;

                for(Integer i : remainders){
                    if(i == a){
                        return counts.get(index);
                    }
                    else{
                        index++;
                    }
                }
            }
            else{
                remainders.add(a);
                counts.add(0);
            }

            //increase all counters
            for(int i = 0; i < counts.size(); i++){
                counts.set(i, counts.get(i)+1);
            }            
        }
    }

    public static void main(String[] args){
        int maxRepeat = 0;
        int d = 0;

        int x = 1000;

        for(int i = 3; i < x; i++){
            int repeat = Main.getNumberRepeats(i);

            if(repeat > maxRepeat){
                maxRepeat = repeat;
                d = i;
            }
        }

        System.out.println("d = " + d);
    }
}