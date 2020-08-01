import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args){
        int[] coinValues = {1, 2, 5, 10, 20, 50, 100, 200};
        int target = 200;

        int[] ways = new int[target+1];
        ways[0] = 1;

        for(int i = 0; i < coinValues.length; i++){
            for(int j = coinValues[i]; j <= target; j++){
                ways[j] += ways[j - coinValues[i]];
            }
        }

        System.out.println("Ways: " + ways[200]);
    }
}