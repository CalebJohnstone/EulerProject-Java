import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

public class Main {
    private TreeSet<String> permList = new TreeSet<>();

    public void permute(Integer[] nums) {
        permutation(0, nums.length - 1, nums);
    }

    public void permutation(int start, int end, Integer[] nums) {
        if (start == end) {
            //add the nums[] as a string
            List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums));
            String s = "";
            for(int i = 0; i < list.size(); i++){
                s += list.get(i);
            }

            permList.add(s);
        }
        for (int i = start; i <= end; i++) {
            List<Integer> list = swap(nums, start, i);

            String s = "";
            for(int j = 0; j < list.size(); j++){
                s += list.get(j);
            }

            permList.add(s);
            permutation(start + 1, end, nums);

            List<Integer> list2 = swap(nums, start, i);
            s = "";

            for(int j = 0; j < list2.size(); j++){
                s += list2.get(j);
            }

            permList.add(s);
        }
    }

    private List<Integer> swap(Integer[] arr, int a, int b) {
        if (a == b) {
            return new ArrayList<>(Arrays.asList(arr));
        }
        Integer temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args){
        int max = 9;
        Integer[] numbers = new Integer[max+1];

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = i;
        }

        Main m = new Main();
        m.permute(numbers);

        int count = 1;

        for(String list : m.permList){
            if(count++ == 1000000){
                System.out.println(list);
                break;
            }
        }
    }
}