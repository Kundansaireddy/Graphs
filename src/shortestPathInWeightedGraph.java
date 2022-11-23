import java.util.ArrayList;
import java.util.Stack;

public class shortestPathInWeightedGraph {
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int a, int b,int[][] cost,int weight){

        graph.get(a).add(b);
        cost[a][b] = weight;
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
        int[][] cost = new int[graph.size()][graph.size()];
        addEdge(graph,0,1,cost,2);
        addEdge(graph,0,4,cost,1);
        addEdge(graph,1,2,cost,3);
        addEdge(graph,4,2,cost,2);
        addEdge(graph,4,5,cost,4);
        addEdge(graph,2,3,cost,6);
        addEdge(graph,5,3,cost,1);
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
        int[] dis = new int[graph.size()];
        for(int i=0;i< graph.size();i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[0] = 0;
        while(stack.size()>0){
            int x = stack.pop();
            for(int i:graph.get(x)){
                dis[i]=Math.min(dis[x]+cost[x][i],dis[i]);
            }
        }
        for(int i:dis){
            System.out.println(i);
        }
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
