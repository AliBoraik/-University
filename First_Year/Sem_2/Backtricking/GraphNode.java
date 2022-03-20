package Backtricking;


import java.util.LinkedList;

public class GraphNode {
    int size;
    LinkedList<LinkedList<Vertex>> list;

    public GraphNode(int size) {
        this.size = size;
        list=new LinkedList<>();
        for (int i = 0; i <size ; i++) {
            list.add(new LinkedList<>());
        }
    }
    public void addEdge(int source,int destination){
        Vertex v1=new Vertex(destination);
        Vertex v2=new Vertex(source);
        list.get(source).add(v1);
        list.get(destination).add(v2);
    }
    public void addVertexValue(int source,String value){
        for (int i = 0; i <list.size() ; i++) {
            for (int j = 0; j <list.get(i).size() ; j++) {
                if (list.get(i).get(j).id==source){
                    list.get(i).get(j).value=value;
                }
            }


        }

    }
    public void printGraph(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\nAdjacency list of vertex " + (i));
            System.out.print("children");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(" -> "+(list.get(i).get(j)));
            }
            System.out.println();
        }
    }
}
