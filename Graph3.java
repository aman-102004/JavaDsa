
//Bellman ford Algorithm
// import java.util.*;
// public class Graph3{
//     static class Edge {
//         int src;
//         int dest;
//         int wt;
//         Edge(int s, int d, int w) {
//             this.src = s;
//             this.dest = d;
//             this.wt = w;
//         }
//     }
//     static void createGraph(ArrayList<Edge>[] graph) {
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         // 0 -> 1 (2)
//         graph[0].add(new Edge(0, 1, 2));
//         // 0 -> 2 (4)
//         graph[0].add(new Edge(0, 2, 4));
//         // 1 -> 2 (-4)
//         graph[1].add(new Edge(1, 2, -4));
//         // 2 -> 3 (2)
//         graph[2].add(new Edge(2, 3, 2));
//         // 3 -> 4 (4)
//         graph[3].add(new Edge(3, 4, 4));
//         // 4 -> 1 (-1)
//         graph[4].add(new Edge(4, 1, -1));
//     }

//     public static void bellmanFord(ArrayList<Edge>[] graph,int src){//O(V*E)
//         int dist[]=new int[graph.length];

//         for(int i=0;i<dist.length;i++){
//             if(i!=src){
//                 dist[i]=Integer.MAX_VALUE;
//             }
//         }

//         //bellman ford algo
//         int V=graph.length;
//         for(int i=0;i<V-1;i++){
//             //find all the edges
//             for(int j=0;j<graph.length;j++){
//                 for(int k=0;k<graph[j].size();k++){
//                     Edge e=graph[j].get(k);
//                     //now find u v and wt
//                     int u=e.src;
//                     int v=e.dest;
//                     int wt=e.wt;
//                     if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
//                         dist[v]=dist[u]+wt;
//                     }
//                 }
//             }
//         }

//         //print all the distances
//         for(int i=0;i<dist.length;i++){
//             System.out.print(dist[i]+" ");
//         }

//     }
//     public static void main(String[] args) {
//         int V = 5;
//         @SuppressWarnings("unchecked")
//         ArrayList<Edge>[] graph = new ArrayList[V];
//         createGraph(graph);

//         bellmanFord(graph, 0);

//     }

// }


//Prims Algorithm

import java.util.*;
public class Graph3{
    static class Edge {
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 -> 1 (10)
        graph[0].add(new Edge(0, 1, 10));
        // 0 -> 2 (15)
        graph[0].add(new Edge(0, 2, 15));

        // 0 -> 3 (30)
        graph[0].add(new Edge(0, 3, 30));
        // 1 -> 0 (10)
        graph[1].add(new Edge(1, 0, 10));
        // 1 -> 3 (40)
        graph[1].add(new Edge(1, 3, 40));
        // 2 -> 0 (15)
        graph[2].add(new Edge(2, 0, 15));
        // 2 -> 3 (50)
        graph[2].add(new Edge(2, 3, 50));
        // 3 -> 0 (30)
        graph[3].add(new Edge(3, 0, 30));
        // 3 -> 1 (40)
        graph[3].add(new Edge(3, 1, 40));
        // 3 -> 2 (50)
        graph[3].add(new Edge(3, 2, 50));
    }


    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }

        public int compareTo(Pair p2){
            return this.cost-p2.cost;//ascending order sorting
        }
    }
    public static void prims(ArrayList<Edge>[] graph){//O(eloge)
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalcost=0;//MST COST/WEIGHT

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalcost+=curr.cost;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }

        System.out.println(finalcost);



    }
    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        prims(graph);

    }

}

//Prims Algo
//Start from any vertex (usually vertex 0).
// Mark it as visited.
// Add all its adjacent edges to a Priority Queue (Min Heap).
// Remove the edge with the minimum weight.
// If its destination is not visited, include that edge in the MST.
// Mark the destination as visited.
// Add all edges from the newly visited vertex.
// Repeat until all vertices are visited.