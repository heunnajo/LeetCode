class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] d = new int[n+1];
        
        d[1] = nums[0];
        if(n>=2) d[2] = Math.max(nums[0],nums[1]);
        
        if(n>=2){
            for(int i=3;i<=n;i++){
                d[i] = Math.max(d[i-2]+nums[i-1],d[i-1]);
            }
        }
        
        // for(int i:d){
        //     System.out.print(i+" ");
        // }
        return d[n];
        
    }
}