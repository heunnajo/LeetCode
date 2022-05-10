
import java.util.*;
class Solution {
    int[] Nums;
    HashMap<Integer,Integer> map;
    int[] selected;
    List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        ans = new ArrayList<>();
        
        if(nums == null) return ans;
        int len = nums.length;
        //nums = [] 인 건 null인 걸까? 객체 생성만하고 값이 없는 것 같은데
        if(len < 3) return ans;
        
        Nums = new int[len];
        for(int i=0;i<len;i++) Nums[i] = nums[i];
        
        map = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        selected = new int[2];
        go(0);//2개의 숫자를 선택
        
        return ans;
    }
    
    void go(int idx){
        //1.stop
        if(idx == 2){
            //c = -(a+b), check if map has key "c". map에 c가 존재하는지 확인.
            //if c is duplicated in Nums, check if the value is more than 1 : c가 중복해서 선택한 수라면 횟수는 2이상이여야함
            int c = -1*(selected[0]+selected[1]);
            
            //c가 중복해서 선택한 수가 아닌 경우 : map에 있는지 확인만 하면 됨
            if(map.get(c) != null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(selected[0]);list.add(selected[1]);list.add(c);
                ans.add(list);
            }
            
            //c가 중복해서 선택한 수인 경우 : map에 있는지에 추가적으로 value값 2이상인지 확인해야함ㅜ
            return;
        }
        //2.select current and select next by a recursion
    }
}
// for(int key:map.keySet()){
        //     System.out.println("key: "+key+"value: "+map.get(key));
        // }