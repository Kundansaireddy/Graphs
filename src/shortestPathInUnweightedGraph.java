import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class shortestPathInUnweightedGraph {
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
            int[] dis = {0,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
            addEdge(graph,0,2);
            addEdge(graph,0,4);
            addEdge(graph,0,1);
            addEdge(graph,1,3);
            addEdge(graph,2,3);
            addEdge(graph,2,4);
            addEdge(graph,3,5);
            addEdge(graph,4,5);
            //printGraph(graph);
            shortestpath(graph,dis,vis,1);
        }

        static void shortestpath(ArrayList<ArrayList<Integer>> graph,int[] dis,boolean[] vis,int count){
            Queue<Integer> q= new ArrayDeque<>();
            q.add(0);
            vis[0]=true;
            while(q.size()!=0){
                int x = q.poll();
                for(int i:graph.get(x)){
                    if(vis[i]==false){
                        vis[i]=true;
                        q.add(i);
                    }
                    dis[i] = Math.min(dis[i],dis[x]+1);
                }
                count++;
            }
            for(int i:dis){
                System.out.println(i);
            }
        }


}
