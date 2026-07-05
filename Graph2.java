// import java.util.*;
// public class Graph2{
//     // Edge Class
//     static class Edge {
//         int src;
//         int dest;
//         Edge(int s, int d) {
//             this.src = s;
//             this.dest = d;

//         }

//     }
//     // Create Graph Function

//     public static void createGraph(ArrayList<Edge>[] graph) {

//         for (int i = 0; i < graph.length; i++) {
//          graph[i] = new ArrayList<>();

//         }

//         // 0 - 1
//         graph[0].add(new Edge(0, 1));
//         graph[1].add(new Edge(1, 0));

//         // 0 - 2

//         graph[0].add(new Edge(0, 2));
//         graph[2].add(new Edge(2, 0));

//         // 1 - 2
//         graph[1].add(new Edge(1, 2));
//         graph[2].add(new Edge(2, 1));

//         // 0 - 3
//         graph[0].add(new Edge(0, 3));
//         graph[3].add(new Edge(3, 0));

//         // 3 - 4
//         graph[3].add(new Edge(3, 4));
//         graph[4].add(new Edge(4, 3));

//     }

//     //we are using loops method in case there are diff kinds componets avaible so to check cycle is ther in any of the components or not
//     //using modified dfs
//     public static boolean detectCycle(ArrayList<Edge> graph[]){
//         boolean vis[]=new boolean[graph.length];
//         for(int i=0;i<graph.length;i++){
//             if(!vis[i]){
//                 if(detectCycleUtil(graph,vis,i,-1)){
//                     return true;
//                     //means cycle is there any of the component
//                 }
//             }
//         }
//         return false;
//     }

//     public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int parent){
//         vis[curr]=true;

//         for(int i=0;i<graph[curr].size();i++){
//             Edge e=graph[curr].get(i);
//             //case3 if node is not visited
//             if(!vis[e.dest]){
//                 if(detectCycleUtil(graph,vis,e.dest,curr)){
//                     return true;
//                 }
                
//             }

//             //case 1 visited is true and the next node is not the parent of this node
//             else if(vis[e.dest]&&e.dest!=parent){
//                 return true;
//             }

//             //case 2 do nothing


//         }

//         return false;

//     }

//     public static void main(String args[]) {
//            /*

//                  0 -------- 3

//                 / \         |

//                /   \        |

//               1-----2       4

//         */
//         int V = 5;
//         @SuppressWarnings("unchecked")
//         ArrayList<Edge>[] graph = new ArrayList[V];
//         createGraph(graph);

//         System.out.println(detectCycle(graph));


//     }

// }

// import java.util.*;
// import java.util.Queue;
// import java.util.LinkedList;
// public class Graph2{
//     // Edge Class
//     static class Edge {
//         int src;
//         int dest;
//         Edge(int s, int d) {
//             this.src = s;
//             this.dest = d;
//         }
//     }
//     // Create Graph
//     public static void createGraph(ArrayList<Edge>[] graph) {

//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         // 0 -> 1, 2
//         graph[0].add(new Edge(0, 1));
//         graph[0].add(new Edge(0, 2));

//         // 1 -> 0, 3
//         graph[1].add(new Edge(1, 0));
//         graph[1].add(new Edge(1, 3));

//         // 2 -> 0, 4
//         graph[2].add(new Edge(2, 0));
//         graph[2].add(new Edge(2, 4));

//         // 3 -> 1, 4
//         graph[3].add(new Edge(3, 1));
//         graph[3].add(new Edge(3, 4));

//         // 4 -> 2, 3
//         graph[4].add(new Edge(4, 2));
//         graph[4].add(new Edge(4, 3));
//     }


//     //we will be using modified bfs
//     //we will be using color method to identify whether a graph is bipartite or not

//     public static boolean isBipartite(ArrayList<Edge>[] graph){//O(v+e)
//         int col[]=new int[graph.length];
//         for(int i=0;i<col.length;i++){
//             col[i]=-1;//no color
//         }
//         Queue<Integer> q=new LinkedList();

//         for(int i=0;i<graph.length;i++){
//             if(col[i]==-1){//BFS PERFORM
//                 q.add(i);
//                 col[i]=0;//yellow color;
//                 while(!q.isEmpty()){
//                     int curr=q.remove();

//                     for(int j=0;j<graph[curr].size();j++){
//                         Edge e=graph[curr].get(j);
//                         if(col[e.dest]==-1){
//                             int nextCol=col[curr]==0?1:0;
//                             col[e.dest]=nextCol;
//                             q.add(e.dest);
//                         }else if(col[e.dest]==col[curr]){
//                             return false;//NOT BIPARTITE

//                         }
//                     }
//                 }

//             }
//         }
//         return true;

//     }
//     public static void main(String args[]) {
//         //if graph is not a cyclic graph then its a bipartite graph by default
//         /*

//                 0 -------- 2
//                /            \
//               /              \
//              1                4
//               \              /
//                \            /
//                 ---- 3---- /


//             FALSE

//         */



//         int V = 5;

//         ArrayList<Edge>[] graph = new ArrayList[V];
//         createGraph(graph);

//         System.out.println(isBipartite(graph));



//         //if acyclic=true;
//         //if even cycle=true;
//         //if odd cycle =false;

        

//     }

// }



//CYCLE DETECTION FOR DIRECTED GRAPH
//WE WILL BE USING AN EXTRA EXPLICIT STACK TO KEEP TRACK OF THE NODES THAT ARE THERE

// import java.util.*;
// import java.util.Queue;
// import java.util.LinkedList;
// public class Graph2{
//     // Edge Class
//     static class Edge {
//         int src;
//         int dest;
//         Edge(int s, int d) {
//             this.src = s;
//             this.dest = d;
//         }
//     }
//     // Create Graph
//     public static void createGraph(ArrayList<Edge>[] graph) {

//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }
//        graph[0].add(new Edge(0,2));

//        graph[1].add(new Edge(1, 0));

//        graph[2].add(new Edge(2, 3));

//        graph[3].add(new Edge(3, 0));
//     }


//     //DFS IS CYCLE
//     //we will be using another array of stack to keep track of call stack

//     public static boolean isCycle(ArrayList<Edge>[] graph){
//         boolean vis[]=new boolean[graph.length];
//         boolean stack[]=new boolean[graph.length];

//         for(int i=0;i<graph.length;i++){
//             if(!vis[i]){
//                if( isCycleUtil(graph,i,vis,stack)){
//                     return true;
//                }
//             }
//         }
//         return false;


//     }

//     public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,boolean[] stack){
//          vis[curr]=true;
//          stack[curr]=true;

//          for(int i=0;i<graph[curr].size();i++){
//             Edge e=graph[curr].get(i);
//             if(stack[e.dest]){//cycle condition
//                 return true;
//             }

//             if(!vis[e.dest] && isCycleUtil(graph,e.dest,vis,stack)){
//                 return true;
//             }


//          }
//          stack[curr]=false;
//          return false;
//     }
    
//     public static void main(String args[]) {
       

//         int V = 4;
//         @SuppressWarnings("unchecked")
//         ArrayList<Edge>[] graph = new ArrayList[V];
//         createGraph(graph);

//         System.out.println(isCycle(graph));


        

//     }

// }


//TOPOLOGICAL SORT(DEPENDENCY SORTING)
//USING DFS AND A STACK
// import java.util.*;
// import java.util.Queue;
// import java.util.LinkedList;
// public class Graph2 {

//     static class Edge {
//         int src;
//         int dest;
//         Edge(int s, int d) {
//             this.src = s;
//             this.dest = d;
//         }
//     }
//     static void createGraph(ArrayList<Edge>[] graph) {

//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         // 2 -> 3

//         // graph[0].add(new Edge(0, 3)); only added this for all paths code
//         graph[2].add(new Edge(2, 3));

//         // 3 -> 1
//         graph[3].add(new Edge(3, 1));
//         // 4 -> 0, 1
//         graph[4].add(new Edge(4, 0));

//         graph[4].add(new Edge(4, 1));

//         // 5 -> 0, 2
//         graph[5].add(new Edge(5, 0));
//         graph[5].add(new Edge(5, 2));

//     }

    //topological sort using dfs
    // public static void topologicalSort(ArrayList<Edge>[] graph){ 
    //     boolean vis[]=new boolean[graph.length];
    //     Stack<Integer> s=new Stack<>();

    //     for(int i=0;i<graph.length;i++){
    //         if(!vis[i]){
    //             topologicalSortUtil(graph,i,vis,s);//dfs
    //         }
    //     }

    //     while(!s.isEmpty()){
    //         System.out.print(s.pop()+" ");
    //     }

    // }

    // public static void topologicalSortUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,Stack<Integer> s){
    //     vis[curr]=true;

    //     for(int i=0;i<graph[curr].size();i++){
    //         Edge e=graph[curr].get(i);
    //         if(!vis[e.dest]){
    //             topologicalSortUtil(graph, e.dest,vis,s);
    //         }
    //     }

    //     s.push(curr);
    // }


//     //TOPOLOGICAL SORT USING BFS-KAHN's ALGO
//     public static void calIndeg(ArrayList<Edge>[] graph,int[] indeg){
//         for(int i=0;i<graph.length;i++){
//             int v=i;
//             for(int j=0;j<graph[v].size();j++){
//                 Edge e=graph[v].get(j);
//                 indeg[e.dest]++;
//             }
//         }

//     }
//     public static void topSort(ArrayList<Edge>[] graph){
//         int indeg[]=new int[graph.length];
//         calIndeg(graph, indeg);
//         Queue<Integer>q=new LinkedList<>();
        

//         for(int i=0;i<indeg.length;i++){
//             if(indeg[i]==0){
//                 q.add(i);
//             }
//         }

//         while(!q.isEmpty()){
//             int curr=q.remove();
//             System.out.print(curr+" ");

//             for(int i=0;i<graph[curr].size();i++){
//                 Edge e=graph[curr].get(i);
//                 indeg[e.dest]--;
//                 if(indeg[e.dest]==0){
//                     q.add(e.dest);
//                 }
//             }
            
//         }

//     }

//     public static void printAllpath(ArrayList<Edge> graph[],int src,int dest,String path){//it has a exponential time complexity O(v^v)
//         if(src==dest){
//             System.out.println(path+dest);
//             return;
//         }

//         for(int i=0;i<graph[src].size();i++){
//             Edge e=graph[src].get(i);
//             printAllpath(graph, e.dest, dest, path+src+"->");
//         }

        
//     }
//     public static void main(String[] args) {

//         int V = 6;
//         @SuppressWarnings("unchecked")
//         ArrayList<Edge>[] graph = new ArrayList[V];
//         createGraph(graph);

//         // topSort(graph);

//         int src=5;
//         int dest=1;
//         printAllpath(graph, src, dest,"");





//     }

// }




import java.util.*;
public class Graph2{
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
        // 0 -> 1 (2)
        graph[0].add(new Edge(0, 1, 2));
        // 0 -> 2 (4)
        graph[0].add(new Edge(0, 2, 4));
        // 1 -> 3 (7)
        graph[1].add(new Edge(1, 3, 7));
        // 1 -> 2 (1)
        graph[1].add(new Edge(1, 2, 1));
        // 2 -> 4 (3)
        graph[2].add(new Edge(2, 4, 3));
        // 3 -> 5 (1)
        graph[3].add(new Edge(3, 5, 1));
        // 4 -> 3 (2)
        graph[4].add(new Edge(4, 3, 2));
        // 4 -> 5 (5)
        graph[4].add(new Edge(4, 5, 5));

    }
    static class Pair implements Comparable<Pair>{//this pair class to store node and its shortest distance
        int n;
        int path;

        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;//path based sorting
        }
    }
    public static void dijistra(ArrayList<Edge>[] graph,int src){//time complexity=v+Elogv
        int dist[]=new int[graph.length];//to store distance dist[i]=srt to i distance;
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;//intialise everydistance by infinitily leaving source
            }
        }  

        boolean[] vis=new boolean[graph.length];

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));//src to src pair

        //now bfs loop
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                //now update the disatnce of the neigbours
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;

                    //updation from source to v
                    if(dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }

                }
            }
        }

        //print all distances
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src=0;
        dijistra(graph, src);



        

    }

}