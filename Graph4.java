import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph4 {
    //CHEAPEST FLIGHT WITH K STOPS
    // static class Edge{
    //     int src;
    //     int dest;
    //     int wt;

    //     public Edge(int s,int d,int w){
    //         this.src=s;
    //         this.dest=d;
    //         this.wt=w;
    //     }
    // }

    // public static void createGraph(int flights[][],ArrayList<Edge> graph[]){
    //     for(int i=0;i<graph.length;i++){
    //         graph[i]=new ArrayList<>();
    //     }
    //     for(int i=0;i<flights.length;i++){
    //         int src=flights[i][0];
    //         int dest=flights[i][1];
    //         int wt=flights[i][2];

    //         Edge e=new Edge(src,dest,wt);
    //         graph[src].add(e);

    //     }
    // }
    // static class Info{
    //     int v;
    //     int cost;
    //     int stops;

    //     public Info(int v,int c,int s){
    //         this.v=v;
    //         this.cost=c;
    //         this.stops=s;
    //     }

    // }
    // public static int cheapestflight(int n,int flights[][],int src,int dest,int k){
    //     @SuppressWarnings("unchecked")
    //     ArrayList<Edge> graph[]=new ArrayList[n];
    //     createGraph(flights, graph);

    //     //performing djistra
    //     int dist[]=new int[n];
    //     for(int i=0;i<n;i++){
    //         if(i!=src){
    //             dist[i]=Integer.MAX_VALUE;
    //         }
    //     }
    //     @SuppressWarnings("unchecked")
    //     Queue<Info> q=new LinkedList();
    //     q.add(new Info(src,0,0));

    //     while(!q.isEmpty()){
    //         Info curr=q.remove();
    //         if(curr.stops>k){
    //             break;
    //         }
    //         for(int i=0;i<graph[curr.v].size();i++){
    //             Edge e=graph[curr.v].get(i);
    //             int u=e.src;
    //             int v=e.dest;
    //             int wt=e.wt;
    //             // we can use this dist[u]!=Integer.MAX_VALUE We need to check this so that when we add or sbtract something it does not give some unknown value
    //             if(curr.cost+wt<dist[v] && curr.stops<=k){
    //                 dist[v]=curr.cost+wt;
    //                 q.add(new Info(v,dist[v],curr.stops+1));
    //             }
    //         }
    //     }

    //     //dest[dist]

    //     if(dist[dest]==Integer.MAX_VALUE){
    //         return -1;
    //     }else{
    //         return dist[dest];
    //     }

    // }

    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;

        public Edge(int dest,int cost){
            this.dest=dest;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge e2){
           return this.cost-e2.cost; 
        }
    }

    public static int connectCities(int cities[][]){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        boolean vis[]=new boolean[cities.length];

        pq.add(new Edge(0, 0));

        int finalcost=0;

        while(!pq.isEmpty()){
            Edge curr=pq.remove();
            if(!vis[curr.dest]){
                vis[curr.dest]=true;
                finalcost+=curr.cost;

                for(int i=0;i<cities[curr.dest].length;i++){
                    if(cities[curr.dest][i]!=0){
                        pq.add(new Edge(i,cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalcost;
    }
    public static void main(String[] args) {
        //CHEAPEST FLIGHT WITH K STOPS
        //WE HAVE TO REACH THE DEST IN K STOPS AND CONSIDERIGN THE MINIMUM COST
        //WE WILL BE USING A ENHANCED DJISTRA FOR SOLVING THIS
        // int n=4;
        // int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        // int src=0,dest=3,k=1;
        

        // System.out.println(cheapestflight(n, flights, src, dest, k));




        // Connecting cities code-using prims algo
        //que where we do not need to put all the info in the graph we can use it directly for prism algo

        int cities[][]={{0,1,2,3,4},
                        {1,0,5,0,7},
                        {2,5,0,6,8},
                        {3,0,6,0,0},
                        {4,7,0,0,0}};

        System.out.println(connectCities(cities));

    }
    
}
