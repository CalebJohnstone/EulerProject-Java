import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    private List<String> permList = new ArrayList<>();

    public void permute(String[] nums) {
        permutation(0, nums.length - 1, nums);
    }

    public void permutation(int start, int end, String[] nums) {
        if (start == end) {
            //add the nums[] as a string
            List<String> list = new ArrayList<String>(Arrays.asList(nums));
            String s = "";

            for(int i = 0; i < list.size(); i++){
                s += list.get(i);
            }

            permList.add(s);
        }

        for (int i = start; i <= end; i++) {
            List<String> list = swap(nums, start, i);

            String s = "";

            for(int j = 0; j < list.size(); j++){
                s += list.get(j);
            }

            permList.add(s);
            permutation(start + 1, end, nums);

            List<String> list2 = swap(nums, start, i);
            s = "";

            for(int j = 0; j < list2.size(); j++){
                s += list2.get(j);
            }

            permList.add(s);
        }
    }

    private List<String> swap(String[] arr, int a, int b) {
        if (a == b) {
            return new ArrayList<String>(Arrays.asList(arr));
        }

        String temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;

        return new ArrayList<String>(Arrays.asList(arr));
    }

    public static void main(String[] args){
        List<String> primes = new ArrayList<String>();

        try{
			//use scanner to read in the text file
			File file = new File("primes.txt");
			Scanner sc;
            sc = new Scanner(file);

            while(sc.hasNextLine()){                
                primes.add(sc.nextLine());
            }

            //implement the actual solution
            
            /*for(String p : primes){

            }*/
        }
        catch(Exception e){
            e.printStackTrace();
        }

        int upper = 4;//debug 6

        for(int n = 4; n <= upper; n++){
            //make each combination of where to replace a number with *
            String[] digits = new String[n];
            digits[0] = digits[1] = "*";

            for(int j = 2; j < n; j++){
                digits[j] = "-";
            }

            Main m = new Main();
            m.permute(digits);

            int end = 1;//m.permList.size()
            int start = 0;//0

            for(int i = start; i < end; i++){
                //System.out.println(permutation);
                String permutation = m.permList.get(i);

                //store the indices for where there is a *
                int first = permutation.indexOf("*");
                int second = permutation.lastIndexOf("*");

                int replaceCount = 0;
                int index = 0;

                for(int k = 0; k < primes.size(); k++){
                    if(primes.get(k).charAt(first) == primes.get(k).charAt(second)){
                        System.out.println(primes.get(k));

                        String p = primes.get(k);
                        char d = p.charAt(first);

                        //find numbers with the same character at pos: first and second
                        for(int j = k+1; j < primes.size(); j++){
                            if((primes.get(j).charAt(first) == primes.get(j).charAt(second)) && (primes.get(j).charAt(first) != d)){
                                System.out.println(primes.get(j));
                            }
                        }

                        System.out.println();
                    }
                }
            }
        }
    }
}