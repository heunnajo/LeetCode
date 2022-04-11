import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int begin = 0, end = 0, ans = 0;
        Set set = new HashSet<>();
        
        while(end<len){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(begin++));
            } else{
                set.add(s.charAt(end++));
                ans = Math.max(ans,end-begin);
            }
        }
        return ans;
    }
}