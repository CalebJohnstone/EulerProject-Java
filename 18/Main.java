public class Main {
    public static void main(String[] args){
        Graph g = new Graph("graph.txt");

        int maxDistance = g.getPathLength("75(1),END");
        System.out.println("Maximum Path Distance: " + maxDistance);
        System.out.println("Path: " + g.getPath("75(1)", "END"));

        //print adjacency matrix
        g.printAdjacencyMatrix("g");
        /*

        //print the distances for the bottom row
        String[] exitRow = {"4(15.1)", "62", "98(15.1)", "27(15)", "23(15.1)", "9", "70(15)", "98(15.2)", "73(15)", "93", "38(15)", "53(15)", "60", "4(15.2)", "23(15.2)"};

        System.out.println();

        for(int i = 0; i < exitRow.length; i++){
            System.out.println(exitRow[i] + ": " + (75+g.getPathLength("75(1)," + exitRow[i])));
        }*/
    }
}