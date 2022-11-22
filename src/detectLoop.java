import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class detectLoop {
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
            for(int i=0;i<4;i++){
                graph.add(new ArrayList<>());
            }
            addEdge(graph,0,1);
            addEdge(graph,0,2);
            addEdge(graph,1,2);
            addEdge(graph,1,3);
            addEdge(graph,2,3);
            //printGraph(graph);
            boolean[] vis = new boolean[4];
            boolean res=dfs(graph,0,0,vis);
            System.out.println(res);
        }

        static boolean dfs(ArrayList<ArrayList<Integer>> graph,int source,int parent, boolean[] vis){
            vis[source] = true;
            for(int i:graph.get(source)){
                if(vis[i]==false){
                    if(dfs(graph,i,source,vis) == true) return true;
                }
                else if(i!=parent) return true;
            }
            return false;
        }
}
