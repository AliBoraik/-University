package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        // List edge

        List<Edge<Integer>> graph=new ArrayList<>();
        graph.add(new Edge<>(1, 7));
        graph.add(new Edge<>(1, 2));
        graph.add(new Edge<>(2, 3));
        graph.add(new Edge<>(2, 7));
        graph.add(new Edge<>(3, 4));
        graph.add(new Edge<>(3, 5));
        graph.add(new Edge<>(3, 6));
        graph.add(new Edge<>(5, 6));
        graph.add(new Edge<>(5, 7));
        graph.add(new Edge<>(6, 7));

        // Abjectly Matrix
        int size=getTops(graph);

        int[][] arr=new int[size][size];
        for (int i = 0; i <size ; i++) {
            int num=i+1;
            for (int j = 0; j < graph.size() ; j++) {
                if (graph.get(j).top1==num){
                    arr[i][graph.get(j).top2-1]=1;
                }else if (graph.get(j).top2==num){
                    arr[i][graph.get(j).top1-1]=1;
                }
            }
        }
        // AdjacencyList 
        AdjacencyList adjacencyList=new AdjacencyList(size);
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                if (arr[i][j]==1) {
                    adjacencyList.addEdge(i,j);
                }
            }
        }
        adjacencyList.printGraph();

        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


    }

    private static int getTops(List<Edge<Integer>> graph) {
        Set<Integer> tops=new HashSet<>();
        for (Edge<Integer> integerEdge : graph) {
            tops.add(integerEdge.getTop1());
            tops.add(integerEdge.getTop2());
        }
        return tops.size();
    }
}
