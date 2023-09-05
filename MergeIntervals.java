//MergeIntervals : debugging
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });

        int n = intervals.length;//4
        for(int i=n-2;i>=0;i--){
            //1.overlap
            //System.out.println("i: "+i);
            if(intervals[i][1] >= intervals[i+1][0]){//i=2,i+1=3
                
                intervals[i][1] = Math.max(intervals[i][1],intervals[i+1][1]);
                intervals[i+1][0] = intervals[i+1][1] = -1;
                n--;
            } 
        }
        
        int idx = 0;
        int[][] answer = new int[n][2];
        //System.out.println("intervals.length: "+intervals.length);//초기 그대로 4로 예상
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0] != -1){
                answer[idx][0] = intervals[i][0];
                answer[idx++][1] = intervals[i][1];
            }
        }

        return answer;
    }
}