import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
public class topologicalSorting {
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
//            addEdge(graph,0,2);
//            addEdge(graph,0,3);
//            addEdge(graph,1,3);
//            addEdge(graph,1,4);
            addEdge(graph,0,2);
            addEdge(graph,0,4);
            addEdge(graph,0,1);
            addEdge(graph,1,3);
            addEdge(graph,2,3);
            addEdge(graph,2,4);
            addEdge(graph,3,5);
            addEdge(graph,4,5);
            int[] indegree = new int[graph.size()];
            for(int i=0;i<6;i++){
                for(int j=0;j<6;j++){
                    for(int k:graph.get(j)){
                        if(k==i) indegree[i]+=1;
                    }
                }
            }
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=0;i<indegree.length;i++){
                if(indegree[i]==0) q.add(i);
            }
            while(q.size()!=0){
                int x = q.poll();
                System.out.println(x);
                for(int i:graph.get(x)){
                    indegree[i]-=1;
                    if(indegree[i]==0) q.add(i);
                }
            }
        }


}
