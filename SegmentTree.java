public class SegmentTree {
    static int tree[];

    public static void init(int n){
        tree=new int[4*n];
    }

    //sti is the child index of the root;//2*i+1 for left and 2*i+2 for right
    public static int buildST(int arr[],int i,int start,int end){
        if(start==end){
            tree[i]=arr[start];
            return arr[start];
        }

        int mid=(start+end)/2;
        buildST(arr, 2*i+1, start,mid);
        buildST(arr, 2*i+2, mid+1, end);
        tree[i]=tree[2*i+1]+tree[2*i+2];
        return tree[i];
    }

    //i==tree index,si sj=start and end index of the sum of ith node,qi and qj are index of the sum reqd
    public static int getSumUtil(int i,int si,int sj ,int qi,int qj){
        //case 1 -completely non overlapping
        if(qj<=si || qi>=sj){
            return 0;//means the sum of current si and sj is not needed
        }else if(si>=qi && sj<=qj){//complete overlap
            return tree[i];

        }else{
            int mid=(si+sj)/2;
            int left=getSumUtil(2*i+1, si, mid, qi, qj);
            int right=getSumUtil(2*i+2, mid+1, sj, qi, qj);
            return left+right;

        }
    }

    public static int getSum(int arr[],int qi,int qj){
        int n=arr.length;
        return getSumUtil(0,0, n-1, qi, qj);
    }


    //construction time complexity=O(n);
    //query and update time complexity logn
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;

        init(n);
        buildST(arr,0, 0, n-1);

        // for(int i=0;i<tree.length;i++){
        //     System.out.print(tree[i]+" ");
        // }

        System.out.println(getSum(arr,2,5));

    }
    
}


//Segment tree is used for Range Queries problem (Where we have to solve different no of queries on different range of values)
//Segment tree allows query and update method to be done in O(logn) time
//so thus we need segment tree when we need to perform operations on large number of queries and then update them
//its a tree kind of ds()
//each node contains special information for a range
//A segment tree is formed using divide and conquer technique 
//means the the tree like structure that we create while dividing similar is the structure of the segment tree
//the values we get by dividing in each steps the sum of that whole is one node of the segmemt tree
//each level consist of 2^n nodes
//this forms a gp
//total levels in a segment tree is logn(base 2)(as at each level the size of array becomes half so at last n/2^x=1 by solving this we get)
//total no of nodes = 2n-1(n is the size of initial elements num) but we will consider 4*n in the code for safety
//meaning of nodes=we will store the sum of the nodes from from starting to end point of the node (for ex the base node will contain the whole sum)(thus range values acc to the meaning of the segment trees)
//thus the nodes of the segment tree will contain sum of the nodes after divide and conquer
//we can define segment tree as a tree like ds whose nodes contain the sum of the nodes which are present after divide and conquer
//it will be a full binary tree