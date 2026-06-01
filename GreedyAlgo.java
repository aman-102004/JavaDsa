import java.util.*;
public class GreedyAlgo {
    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }

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




        //FRACTIONAL KNAPSACK
        // int val[]={60,100,120};
        // int weight[]={10,20,30};
        // int w=50;

        // double ratio[][]=new double[val.length][2];
        // //oth col=idx;
        // //1st col=ratio;
        // for(int i=0;i<val.length;i++){
        //     ratio[i][0]=i;
        //     ratio[i][1]=val[i]/(double)weight[i];

        // }
        // //ascending order Sorting
        // Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        // int capacity=w;
        // int finalVal=0;
        // for(int i=ratio.length-1;i>=0;i--){
        //     int idx=(int)ratio[i][0];
        //     if(capacity>=weight[idx]){
        //         finalVal+=val[idx];
        //         capacity=capacity-weight[idx];
        //     }else{
        //         finalVal+=ratio[i][1]*capacity;
        //         capacity=0;
        //         break;

        //     }
        // }

        // System.out.println("Final Value is:"+ finalVal);


        //MIN ABSOLUTE DIFFERENCE PAIRS
        //O(nlogn)

        // int a[]={4,1,8,7};
        // int b[]={2,3,6,5};

        // Arrays.sort(a);
        // Arrays.sort(b);

        // int mindiff=0;

        // for(int i=0;i<a.length;i++){
        //     mindiff+=Math.abs(a[i]-b[i]);

        // }

        // System.out.println("Min Absolute Diff is "+mindiff);


        //MAX LENGTH PAIRS OF CHAINS
        //same as activity selection always select first pair cause woh jaldi khatm hogi
        //o(nlogn)
        // int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

        // Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));

        // int chainLength=1;

        // int pairend=pairs[0][1];//Last selected pair

        // for(int i=1;i<pairs.length;i++){
        //     if(pairs[i][0]>pairend){
        //         chainLength++;
        //         pairend=pairs[i][1];
        //     }

        // }


        // System.out.println("Max Length of chain is "+chainLength);

        


        //INDIAN COINS
        // Integer coins[]={1,2,5,10,20,50,100,500,2000};
        // Arrays.sort(coins,Comparator.reverseOrder());//to use this array must obe of type Integer class


        // int count=0;
        // int amount=590;
        // ArrayList<Integer>ans=new ArrayList<>();

        // for(int i=0;i<coins.length;i++){
        //     if(coins[i]<=amount){
        //         while(coins[i]<=amount){
        //         count++;
        //         ans.add(coins[i]);
        //         amount-=coins[i];

        //         }
                
        //     }
        // }

        // System.out.println("Total min coins used:"+count);
        // for(int i=0;i<ans.size();i++){
        //     System.out.print(ans.get(i)+" ");
        // }



        //JOB SEQUENCING PROBLEM
         
        int jobsinfo[][]={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs=new ArrayList<>();
        
        for(int i=0;i<jobsinfo.length;i++){
            jobs.add(new Job(i,jobsinfo[i][0],jobsinfo[i][1]));

        }

        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);//arrange objects in descending order of profit
        

        ArrayList<Integer> seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);

            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max Jobs="+seq.size());

        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }



    
    }
    
}
