public class Main {
    public static void main(String[] args){
        int x = 2521;

        while(true){
            boolean found = false;

            for(int i = 2; i <= 20 && !found; i++){
                if(x % i != 0){
                    found = true;
                }
            }

            if(!found){
                System.out.println("Smallest positive number even divisible by [1..20]: " + x);
                break;
            }
            else{
                x++;
            }
        }  
    }
}