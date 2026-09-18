public class SegmentTree {

    public static void main(String[] args) {
        
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