public class Main {
    public static void main(String[] args){
        String[] words = new String[1000];

        //initialise the words to be empty
        for(int i = 0; i < 1000; i++){
            words[i] = "-";
        }

        //set values for all one word numbers

        //1-9
        words[0] = "one";
        words[1] = "two";
        words[2] = "three";
        words[3] = "four";
        words[4] = "five";
        words[5] = "six";
        words[6] = "seven";
        words[7] = "eight";
        words[8] = "nine";

        //10
        words[9] = "ten";

        //11-19
        words[10] = "eleven";
        words[11] = "twelve";
        words[12] = "thirteen";
        words[13] = "fourteen";
        words[14] = "fifteen";
        words[15] = "sixteen";
        words[16] = "seventeen";
        words[17] = "eighteen";
        words[18] = "nineteen";

        //20, 30, ..., 90
        words[19] = "twenty";
        words[29] = "thirty";
        words[39] = "forty";
        words[49] = "fifty";
        words[59] = "sixty";
        words[69] = "seventy";
        words[79] = "eighty";
        words[89] = "ninety";

        //21,22, ..., 29; 31,32, ..., 39 ... 91,92, ... ,99
        for(int i = 2; i <= 9; i++){
            for(int j = 0; j <= 8; j++){
                words[(10*i)+j] = words[(10*i)-1] + " " + words[j];
            }
        }

        //100, 200, ... , 900
        for(int i = 99; i <= 899; i += 100){
            words[i] = words[(i+1)/100 - 1] + " hundred";
        }

        //101, 102, ..., 999
        for(int i = 100; i <= 998; i++){
            if((i+1) % 100 != 0){
                words[i] = words[(i/100 * 100) - 1] + " and " + words[i % 100];
            }
        }

        //1000
        words[999] = "one thousand";

        //print all of the words
        int x = 1000;//1000

        for(int i = 0; i < x; i++){
            System.out.println((i+1) + ": " + words[i]);
        }

        //count all of the letters
        int lettersCount = 0;

        for(int i = 0; i < 1000; i++){
            //count the number of letters for this word
            for(int j = 0; j < words[i].length(); j++){
                if(words[i].charAt(j) != ' '){
                    lettersCount++;
                }
            }
        }

        System.out.println();
        System.out.println("Letter count: " + lettersCount);
    }
}