package Backtricking;

import java.util.Arrays;
import java.util.LinkedList;

public class SetColors {
    public static void main(String[] args) {
        GraphNode graph = new GraphNode(7);

        graph.addEdge(0, 6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        BT_Graph(graph);
        graph.printGraph();

    }
    private static void BT_Graph(GraphNode graph) {
        String[] color = new String[]{"red", "blue", "white", "black", "yellow", "green"};
        for (int i = 0; i < graph.size; i++) {
            for (int j = 0; j < color.length; j++) {
                if (correctColor(graph.list.get(i), color[j])) {
                    setColor(i, color[j], graph);
                    break;
                }
            }
        }
    }
    private static void setColor(int id, String s, GraphNode graph) {
        for (int j = 0; j < graph.size ; j++) {
            for (int k = 0; k <graph.list.get(j).size() ; k++) {
                if (graph.list.get(j).get(k).id==id){
                    graph.list.get(j).get(k).setValue(s);
                }
            }
        }
    }
    private static boolean correctColor(LinkedList<Vertex> vertices, String s) {
        for (int i = 0; i <vertices.size() ; i++) {
            if (vertices.get(i).value.equals(s)){
                return false;
            }
        }
        return true;
    }



}
