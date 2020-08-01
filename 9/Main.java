public class Main {
    public static Long product(){
        for(Long a = 1L; a < 1000; a++){
            for(Long b = a+1; a+b < 1000; b++){
                Long c = 1000 - (a+b);

                //check if (a,b,c) is a Pythagorean triplet
                if(((long) Math.pow(a,2) + (long) Math.pow(b,2) == (long) Math.pow(c,2)) && (a+b+c==1000)){
                    System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                    return a*b*c;
                }
            }
        }

        return 0L;
    }
    public static void main(String[] args){
        Long n = Main.product();
        System.out.println("abc: " + n);
    }
}