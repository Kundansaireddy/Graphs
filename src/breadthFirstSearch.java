import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class breadthFirstSearch {
    //this file is edited in github
    public static void addEdge(ArrayList<ArrayList<Integer>> graph,int a,int b){
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
        for(int i=0;i<4;i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,2);
        addEdge(graph,1,3);
        addEdge(graph,2,3);
        printGraph(graph);
        bfs(graph);
    }
    static void bfs(ArrayList<ArrayList<Integer>> graph){
        boolean[] vis = new boolean[graph.size()];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        vis[0]=true;
        while(q.size()!=0){
                int curr= q.poll();
                System.out.println(curr);
                for(int k:graph.get(curr)){
                    if(vis[k]==false){
                        vis[k]=true;
                        q.add(k);
                    }
                }
        }
    }


}
