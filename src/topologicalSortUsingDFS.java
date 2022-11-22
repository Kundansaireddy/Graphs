import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class topologicalSortUsingDFS {
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
            for(int i=0;i<5;i++){
                graph.add(new ArrayList<>());
            }
            boolean[] vis = new boolean[graph.size()];
            addEdge(graph,0,2);
            addEdge(graph,0,1);
            addEdge(graph,0,3);
            addEdge(graph,1,3);
            addEdge(graph,1,4);
            addEdge(graph,3,4);
            int[] indegree = new int[graph.size()];
            for(int i=0;i<graph.size();i++){
                for(int j=0;j<graph.size();j++){
                    for(int k:graph.get(j)){
                        if(k==i) indegree[i]+=1;
                    }
                }
            }
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<graph.size();i++){
                if(vis[i]==false){
                    dfs(graph,vis,i,stack);
                }
            }
            for(int i:stack) System.out.println(i);
        }
        static void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis,int source,Stack<Integer> st){
            vis[source] =true;
            for(int i:graph.get(source)){
                if(vis[i]==false){
                    dfs(graph,vis,i,st);
                }
            }
            st.push(source);
        }



}
