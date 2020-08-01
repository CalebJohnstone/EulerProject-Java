public class edgeNode {
    public int weight;
    public edgeNode next;

    public edgeNode(int w, edgeNode n){
        this.weight = w;
        this.next = n;

        //System.out.println("w = " + w + ", next = " + n);
    }
}