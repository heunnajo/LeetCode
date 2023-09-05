//MergeIntervals : debugging
class Solution {
    public int[][] merge(int[][] intervals) {
        //1.정렬
        Arrays.sort(intervals,new Comparator<int[]>{
            @Override
            int compare(int[] a,int[] b){
                if(a[0] == b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            }
        });
        //2.합치기
        
    }
}