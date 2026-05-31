import java.util.*;
public class GreedyAlgo {


    public static void main(String[] args) {


        //ACTIVITY SELECTION CODE
        // int start[]={1,3,0,5,8,5};
        // int end[]={2,4,6,7,9,9};
        // //end time sorted basis

        // //if it was not sorted
        // int activities[][]=new int[start.length][3];

        // for(int i=0;i<start.length;i++){
        //     activities[i][0]=i;
        //     activities[i][1]=start[i];
        //     activities[i][2]=end[i];
        // }
        // //Lambda functions to sort 2d arrays
        // //this indicates sorting on the bases of the index 2
        // Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
        // int maxAct=0;

        // ArrayList<Integer> ans=new ArrayList<>();

        // maxAct=1;
        // ans.add(activities[0][0]);
        // int lastend=activities[0][2];
        // for(int i=1;i<end.length;i++){
        //     if(activities[i][1]>=lastend){
        //         maxAct++;
        //         ans.add(activities[i][0]);
        //         lastend=activities[i][2];
        //     }

        // }

        // System.out.println("Max Activites:"+maxAct);

        // for(int i=0;i<ans.size();i++){
        //     System.out.print("A"+ans.get(i)+" ");
        // }

        int val[]={60,100,120};
        int weight[]={10,20,30};
        int w=50;

        double ratio[][]=new double[val.length][2];
        //oth col=idx;
        //1st col=ratio;
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];

        }
        //ascending order Sorting
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capacity=w;
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){
                finalVal+=val[idx];
                capacity=capacity-weight[idx];
            }else{
                finalVal+=ratio[i][1]*capacity;
                capacity=0;
                break;

            }
        }

        System.out.println("Final Value is:"+ finalVal);





    }
    
}
