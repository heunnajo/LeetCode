class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0; int p = 0; int p2 = nums.length-1;
        
        while(p<=p2){
            if(nums[p] == 2) {
                swap(nums,p,p2);
                p2--;
            } else if(nums[p] == 1){
                p++;
            } else if(nums[p] == 0){
                swap(nums,p,p0);
                p0++;
                p++;
            }
        }
    }
    private void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}