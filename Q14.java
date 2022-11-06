//14. Longest Common Prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];//1
        
        String prefix = strs[0];
        int n = strs.length;
        
        for(int i=1;i<n;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";//prefix가 한번이라도 ""가 된다면 LCP 존재X로 판단!
            }
            
        }
        return prefix;
    }
}