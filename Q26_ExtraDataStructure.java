//26. Remove Duplicates from Sorted Array
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        
        int[] newArr = new int[n];
        int idx = 0;
        newArr[idx++] = nums[0];
        for(int i=1;i<n;i++){
            if(newArr[idx-1] == nums[i]){
                //i++;
                continue;
            }
            newArr[idx++] = nums[i];
        }
        for(int i=0;i<idx;i++){
            nums[i] = newArr[i];
        }
        //System.out.println("k=idx:"+idx);
        return idx;
    }
}