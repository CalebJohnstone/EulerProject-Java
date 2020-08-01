public class Main {
    public static boolean isPalindrome(int x){
        //convert to string
        String number = Integer.toString(x);

        for(int i = 0; i < number.length()/2; i++){
            if(number.charAt(i) != number.charAt(number.length()-1-i)){
                return false;
            }
        }

        return true;
    }

    public static int largestPalindrome(){
        int largestPalindrome = 0;

        for(int i = 999; i > 100; i--){
            for(int j = i; j > 100; j--){
                int product = i*j;

                if(Main.isPalindrome(product) && product > largestPalindrome){
                    largestPalindrome = product;
                }
            }
        }

        return largestPalindrome;
    }

    public static void main(String[] args){
        int n = Main.largestPalindrome();
        System.out.println("Final value for -> Largest palindrome: " + n);
    }
}