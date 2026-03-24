import java.util.*;
public abstract class trappingrainwater {

    public static int trappedRainwater(int height[]){
        //calculate left max boundry-array
        int n=height.length;
        int leftmax[]=new int[n];
        leftmax[0]=height[0];
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }
        //calculate right most boundry -array
        int rightmax[]=new int[n];
        rightmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(height[i],rightmax[i+1]);

        }
        //loop
        int trappedWater=0;
                
        for(int i=0;i<n;i++){
            //waterLevel=min(leftmax bound,rightmax bound)
            int waterlevel=Math.min(leftmax[i],rightmax[i]);
            //trapped water =waterlevel-height[i]
            trappedWater+=waterlevel-height[i];

        }
        return trappedWater;

        

    }


    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        System.out.println(trappedRainwater(height)); 
    }
}
