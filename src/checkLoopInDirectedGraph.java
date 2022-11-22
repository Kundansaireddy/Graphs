import java.util.ArrayList;

public class checkLoopInDirectedGraph {
        public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b){
            graph.get(a).add(b);
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
            addEdge(graph,0,1);
            addEdge(graph,2,1);
            addEdge(graph,2,3);
            addEdge(graph,3,4);
            //addEdge(graph,5,3);
            addEdge(graph,4,5);
            printGraph(graph);
            boolean res = dfs(graph,vis,0);
            System.out.println(res);
        }
        static boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int source){
            for(int i=0;i<graph.size();i++){
                boolean[] curr = new boolean[graph.size()];
                if(vis[i]==false)  if (dfssearch(graph, vis, i,curr) == true) return true;
            }
            return false;
        }
        static boolean dfssearch(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int source,boolean[] curr){
            vis[source] = true;
            curr[source] = true;
            for(int i:graph.get(source)){
                if(curr[i]==true) return true;
                else dfssearch(graph,vis,i,curr);
            }
            return false;
        }
}
