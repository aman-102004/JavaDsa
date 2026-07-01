import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
public class Graph1 {

    static class Edge{
        int src;
        int desc;
        int wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.desc=d;
            this.wt=w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge> graph[]){//O(V+E)
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[graph.length];

        //starting from 0 as source
        q.add(0);

        while(!q.isEmpty()){
            int curr=q.remove();
            if(!visited[curr]){//visit current
                System.out.print(curr+" ");
                visited[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.desc);
                }


            }
        }


    }



    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean vis[]){//O(v+E)
        //make the current node visited
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.desc]){
                
                dfs(graph,e.desc, vis);
            }
        }

    }

    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int desc,boolean vis[]){
        if(src==desc){
            return true;

        }
        vis[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            //e.desc is the neighbour
            if(!vis[e.desc] && hasPath(graph, e.desc, desc, vis)){
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
         /*
                  (5)
             0 -------- 1
                      /  \
                 (1) /    \ (3)
                    /      \
                   2 ------ 3
                   |  (1)
                 (2)
                   |
                   |
                   4
        */
        // int v=5;//vertices

        // //create an arrays of similar length of vertices
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge>[] graph=new ArrayList[v];
        // //this is a null array list convert this into a emptyarraylist

        // for(int i=0;i<v;i++){
        //     graph[i]=new ArrayList<>();
        // }

        // //0th vertex
        // graph[0].add(new Edge(0, 1, 5));

        // //1st vertex
        // graph[1].add(new Edge(1,0,5));
        // graph[1].add(new Edge(1,2,1));
        // graph[1].add(new Edge(1,3,3));

        // //2nd vertex
        // graph[2].add(new Edge(2,1,1));
        // graph[2].add(new Edge(2,3,1));
        // graph[2].add(new Edge(2,4,4));

        // //3rd vertex
        // graph[3].add(new Edge(3,1,2));
        // graph[3].add(new Edge(3,2,1));

        // //4th vertex
        // graph[4].add(new Edge(4,2,1));

        // //2's neighbours
        // for(int i=0;i<graph[2].size();i++){
        //     Edge e=graph[2].get(i);
        //     System.out.println(e.desc);

        // }


        //BFS BREADTH FIRST SEARCH TRAVERSE YOUR NEAREST NEIGHBOURS FIRST
            //               1 ----- 3
                    //     /         | \
                    //    0          |  5---6
                    //    \          | /  
                    //     2---------4


        int V=7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        bfs(graph);
        System.out.println();
        dfs(graph,0, new boolean[V]);
        System.out.println();

        System.out.println(hasPath(graph, 0, 5,new boolean[V]));




    }
    
}

//A graph is a collection of nodes
//eg 1->7->2->9 connected using edges and nodes are called a vertex
// we will be using adjacency list for implementing a graph i.e an array of arraylist<Edges> where arraylist will conatain info of the edges (source ,destination,weight)
//it can also be implemeted using an adjacency matrix,edge list and a Implicit graph(assuming that a graph is given in form of a 2d matrix)

//bfs visited nearest neighbours first
//dfs visit adjacent neighbours first


//connected Components
//if wherever we want to check the number of components in a graph(like if there are dijoint graphs 2or 3 graaphs not connected with each other )
//then we just have to conver the dfs/bfs into a util function and call them into a differet function using a loop 
//the number of times bfs/dfs is called that is the number of component in taht graph