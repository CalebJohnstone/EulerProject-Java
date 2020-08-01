public class Main {
    public static void main(String[] args){
        //use pascal's triangle
        Long[][] pascalsTriangle = new Long[40+1][];

        pascalsTriangle[0] = new Long[1];
        pascalsTriangle[0][0] = 1L;

        for(int i = 1; i < 40+1; i++){
            pascalsTriangle[i] = new Long[i+1];

            pascalsTriangle[i][0] = 1L;

            for(int j = 1; j < pascalsTriangle[i].length-1; j++){
                //use pascal's rule
                pascalsTriangle[i][j] = pascalsTriangle[i-1][j-1] + pascalsTriangle[i-1][j];
            }

            pascalsTriangle[i][pascalsTriangle[i].length-1] = 1L;
        }

        for(int i = 0; i < 40+1; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(pascalsTriangle[i][j] + " ");
            }

            System.out.println();
            System.out.println();
        }

        System.out.println("answer: " + pascalsTriangle[40][20]);
        
    }
}