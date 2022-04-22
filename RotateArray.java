class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<k) k = k%(nums.length);
        for(int i=0;i<k;i++){
            rotate(nums);
        }
    }
    void rotate(int[] nums){
        int len = nums.length;
        int tmp = nums[len-1];
        
        for(int i=len-1;i>=1;i--){
            nums[i] = nums[i-1];
        }
        nums[0] = tmp;
    }
}