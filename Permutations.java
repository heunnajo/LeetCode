//LeetCode #46
import java.util.*;
class Solution {
    List<List<Integer>> ans;
    int len;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();//우변은 구현체 나와야하는 거 아닌가?왜 cannot converted라고 나오지?
        len = nums.length;
        
        LinkedList<Integer> tmpAns;
        Arrays.sort(nums);
        do{
            //nums를 list에 추가
            tmpAns = new LinkedList<>();
            
            for(int i=0;i<len;i++) tmpAns.add(nums[i]);
            
            ans.add(tmpAns);
            
        } while(next_permu(nums));
        
        return ans;
    }
    boolean next_permu(int[] nums){
        int i = len-1;
        while(i>0 && nums[i-1] > nums[i]) i--;
        
        if(i == 0) return false;
        
        int j = len-1;
        while(nums[i-1] > nums[j]) j--;
        
        int tmp = nums[i-1];
        nums[i-1] = nums[j];
        nums[j] = tmp;
        
        j = len-1;
        while(i<j){//등호가 없어도 되나?!!!!!
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++; j--;
        }
        return true;
    }
}