//MergeIntervals
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        
        int n = intervals.length;//4
        // System.out.println("e 오름차순 정렬 확인");
        // for(int i=0;i<n;i++){
        //     System.out.println(intervals[i][0]+","+intervals[i][1]);
        // }
        for(int i=n-2;i>=0;i--){
            if(intervals[i][1] >= intervals[i+1][0]){//i=2,i+1=3
                //System.out.println("i: "+i);//여기에 들어오긴 하는데. 왜 -1로 제대로 안 되고, 그리고 n도 감소 안하냐.
                intervals[i][0] = Math.min(intervals[i][0],intervals[i+1][0]);
                intervals[i][1] = Math.max(intervals[i][1],intervals[i+1][1]);
                //intervals[i+1][0] = intervals[i+1][1] = -1;//1ㅂㅓㄴ 우ㅓㄴ소는 -1이 되야하는데!
                intervals[i+1][0] = -1;
                intervals[i+1][1] = -1;
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