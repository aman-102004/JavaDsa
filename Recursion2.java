public class Recursion2 {

    public static int tilingProblem(int n){//2 x n is the size of the floor
        //work
        //first vertical choice
        
        if(n==0 || n==1){
            return 1;
        }
        
        int fnm1=tilingProblem(n-1);

        //horizonatal choide
        int fnm2=tilingProblem(n-2);

        int totalways=fnm1+fnm2;

        return totalways;
    }

    public static void RemoveDuplicates(String str,int idx,StringBuilder sb,boolean map[]){
        if(idx==str.length()){
            System.out.println(sb);
            return;
        }
        char currchar=str.charAt(idx);
        if(map[currchar-'a']==true){
            RemoveDuplicates(str,idx+1,sb,map);
        }
        else{
            map[currchar-'a']=true;
            RemoveDuplicates(str, idx+1, sb.append(currchar), map);
        }
    }
    public static void main(String[] args) {
        // System.out.println(tilingProblem(3));

        String str="aapnaaaacollegge";
        RemoveDuplicates(str,0,new StringBuilder(""),new boolean[26]);

    }

    
}
