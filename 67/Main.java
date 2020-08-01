import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //read from the text file into the table
        try{
			//use scanner to read in the text file
			File file = new File("inputTriangle.txt");
			Scanner sc;
            sc = new Scanner(file);
            
            //15
            int numLines = Integer.parseInt(sc.nextLine());

            int[][] inputTriangle = new int[numLines][];

            int i = 0;

            while(sc.hasNextLine()){
                //eg: 88 02 77 73 07 63 67
                String[] line = sc.nextLine().split(" ");

                inputTriangle[i] = new int[line.length];

                for(int j = 0; j < line.length; j++){
                    inputTriangle[i][j] = Integer.parseInt(line[j]);
                }

                i++;
            }

            //output the triangle
            for(int a = 0; a < numLines; a++){
                System.out.print("Line " + (a+1) + ": ");

                for(int j = 0; j < inputTriangle[a].length; j++){
                    System.out.print(inputTriangle[a][j] + " ");
                }

                System.out.println();
            }

            System.out.println();

            //algorithm
            for(int row = numLines-1; row > 0; row--){
                for(int col = 0; col < row; col++){
                    inputTriangle[row-1][col] += Math.max(inputTriangle[row][col], inputTriangle[row][col+1]);
                }
            }

            System.out.println("Maximum path length: " + inputTriangle[0][0]);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}