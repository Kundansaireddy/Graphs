import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class kahnsAlgorithm {
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
            for(int i=0;i<4;i++){
                graph.add(new ArrayList<>());
            }
            boolean[] vis = new boolean[graph.size()];
            addEdge(graph,0,1);
            addEdge(graph,1,2);
            //addEdge(graph,2,0);
            addEdge(graph,2,3);

            int[] indegree = new int[graph.size()];
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    for(int k:graph.get(j)){
                        if(k==i) indegree[i]+=1;
                    }
                }
            }
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=0;i<indegree.length;i++){
                if(indegree[i]==0) q.add(i);
            }
            int count=0;
            while(q.size()!=0){
                int x = q.poll();
                System.out.println(x);
                for(int i:graph.get(x)){
                    indegree[i]-=1;
                    if(indegree[i]==0) q.add(i);
                }
            }
            System.out.println(count);
            System.out.println("The graph is cyclic:"+(count!=4));
        }




}
