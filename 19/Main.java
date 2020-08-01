public class Main {
    public static void main(String[] args){
        int[] dayStartCounter = new int[7];

        for(int i = 0; i < 7; i++){
            dayStartCounter[i] = 0;
        }

        int[] monthLengths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] monthNames = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        String[] dayNames = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int dayStart = 1;
        dayStartCounter[2] = 1;

        //year
        for(int i = 1901; i <= 2000; i++){
            //month
            for(int j = 1; j <= 12; j++){
                System.out.println("1 " + monthNames[j-1] + " " + i + ": " + dayNames[dayStart]);

                dayStart += monthLengths[j-1]-28;

                //check if feb and leapy year
                if((j == 2) && ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0))){
                    dayStart++;
                }

                dayStart %= 7;

                //increase day counter
                dayStartCounter[dayStart]++;
            }
        }

        System.out.println("Number of Sunday starts: " + dayStartCounter[6]);
    }
}