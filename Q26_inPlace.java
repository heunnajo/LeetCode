//26. Remove Duplicates from Sorted Array

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int idx = 0;
        
        for(int i=0;i<n-1;i++){
            if(nums[i] != nums[i+1]){
                nums[idx++] = nums[i];
            }
        }
        nums[idx++] = nums[n-1];
        return idx;
    }
}