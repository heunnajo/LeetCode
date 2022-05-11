class Solution {
    String Digits;
    int n;
    List<String> list;
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        list = new LinkedList<>();
        if(digits.length() == 0) return list;//edge case : when the length of digits is 0
        
        n = digits.length();
        Digits = digits;
        
        go(0,"");
        
        return list;
    }
    void go(int idx,String selected){
        //1.재귀 종료
        if(idx == n){
            list.add(selected);
            return;
        }
        
        //2.현재 선택, 다음 선택(재귀 호출)
        String cur = map[Digits.charAt(idx)-'0'];
        int k = cur.length();
        for(int i=0;i<k;i++){
            go(idx+1,selected+cur.charAt(i));
        }
    }
}