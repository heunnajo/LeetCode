class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return;
        if(n == 1) return;
        if(n<k) k = k%n;
        
        int offset = n-k;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(i>=k) res[i] = nums[i-k];
            else res[i] = nums[offset+i];
        }
        for(int i=0;i<n;i++){
            nums[i] = res[i];   
        }
    }
}