package Graph;


import java.util.LinkedList;

public class AdjacencyList {
    int size;
    LinkedList<LinkedList<Integer>> list;

    public AdjacencyList(int size) {
        this.size = size;
        list=new LinkedList<>();
        for (int i = 0; i <size ; i++) {
            list.add(new LinkedList<>());
        }
    }
    public void addEdge(int source,int destination){
        list.get(source).add(destination);
//        list.get(destination).add(source);
    }
    public void printGraph(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\nAdjacency list of vertex " + (i+1));
            System.out.print("head");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(" -> "+(list.get(i).get(j)+1));
            }
            System.out.println();
        }
    }
}
