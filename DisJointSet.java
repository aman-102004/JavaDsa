// public class DisJointSet {
//     static int n=7;
//     static int par[]=new int[n];
//     static int rank[]=new int[n];

//     public static void init(){
//         for(int i=0;i<n;i++){
//             par[i]=i;
//         }
//     }

//     //In find we return thr leader of the value and if uska bhi leader hai then recursively call krke leader dhoodho

//     public static int find(int x){
//         if(x==par[x]){
//             return x;

//         }
//         // return find(par[x]);
//         return par[x]=find(par[x]);//after compression

//     }

//     public static void union(int a,int b){
//         int parA=find(a);
//         int parB=find(b);

//         if(rank[parA]==rank[parB]){
//             //kisi ko bhi bana do
//             par[parB]=parA;
//             rank[parA]++;
//         }else if(rank[parA]<rank[parB]){
//             par[parA]=parB;
//         }else{
//             par[parB]=parA;
//         }
//     }

//     //O(1) union and find both
//     public static void main(String[] args) {
//         init();
//         union(1, 3);
//         System.out.println(find(3));
//         union(2, 4);
//         union(3,6);
//         union(1,4);
//         System.out.println(find(3));
        
//     }
// }




//KrushKal Algoritm
//arrange edges in inc order of weight
//greedily select edge with min wieght
//check if cycle forms or not using disjoint union if forms do not add that edge else add it
import java.util.*;
public class DisJointSet{
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;

        }
        @Override
            public int compareTo(Edge e2){
                return this.wt-e2.wt;
            }
    }

    static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
        
    }
    static int n=4;//no of vertices
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    //In find we return thr leader of the value and if uska bhi leader hai then recursively call krke leader dhoodho

    public static int find(int x){
        if(x==par[x]){
            return x;

        }
        // return find(par[x]);
        return par[x]=find(par[x]);//after compression

    }

    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]==rank[parB]){
            //kisi ko bhi bana do
            par[parB]=parA;
            rank[parA]++;
        }else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }

    //O(V+eloge)
    public static void kruskalMST(ArrayList<Edge> edges,int V){
        init();
        Collections.sort(edges);
        int mstCost=0;
        int count=0;;

        for(int i=0;count<V-1;i++){
            Edge e=edges.get(i);
            //(src,dest,wt)

            int parA=find(e.src);
            int parB=find(e.dest);

            if(parA!=parB){//parA==parB cycle condition
                union(e.src,e.dest);
                mstCost+=e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges=new ArrayList<>();
        createGraph(edges);
        kruskalMST(edges, V);
    }
}
