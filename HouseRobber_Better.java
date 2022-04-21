class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        
        int[] d = new int[n+1];
        
        d[1] = nums[0];
        
        for(int i=2;i<=n;i++){
            d[i] = Math.max(d[i-2]+nums[i-1],d[i-1]);
        }

        return d[n];
        
    }
}