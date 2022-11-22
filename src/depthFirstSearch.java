import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class depthFirstSearch {
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
    static void printGraph(ArrayList<ArrayList<Integer>> graph){
        for(int i=0;i< graph.size();i++){
            System.out.print(i+":");
            for(int k:graph.get(i)){
                System.out.print(k+" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<6;i++){
            graph.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[graph.size()];
        addEdge(graph,0,2);
        addEdge(graph,0,4);
        addEdge(graph,0,1);
        addEdge(graph,1,3);
        addEdge(graph,2,3);
        addEdge(graph,2,4);
        addEdge(graph,3,5);
        addEdge(graph,4,5);
        printGraph(graph);
        dfs(graph,vis,0);
    }
    static void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int source){
        vis[source]=true;
        System.out.println(source);
        for(int i:graph.get(source)){
            if(vis[i]==false){
                dfs(graph,vis,i);
            }
        }
    }
}
