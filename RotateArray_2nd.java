class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k==0) return;
        if(n == 1) return;
        if(n<k) k = k%n;
        
        int offset = n-k;
        int[] tmp = new int[k];
        for(int i=0;i<k;i++){
            tmp[i] = nums[offset+i];
            //System.out.print(tmp[i]+" ");
        }
        for(int i=n-1;i>=k;i--){
            nums[i] = nums[i-k];
        }
        
        for(int i=0;i<k;i++){
            nums[i] = tmp[i];
        }
    }
}