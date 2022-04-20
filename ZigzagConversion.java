class Solution {
    public String convert(String s, int numRows) {
        //엣지 케이스 처리(백트랙킹)
        //1.s의 길이 = numRows 2.numRows = 1
        if(s.length() == numRows) return s;
        if(numRows == 1) return s;
        
        String[] sArr = s.split("");
        
        //각 문자에 대해 반복!
        int idx = 0;
        String[] ans = new String[numRows];//정답을 저장하는 String 객체 각 배열값을 ""로 초기화함. 왜지?
        for(int i=0;i<numRows;i++) ans[i] = "";
        
        boolean flag = true;
        
        for(String str:sArr){
            ans[idx] += str;
            
            if(flag){
                if(idx<numRows-1) idx++;
                else if(idx == numRows-1){
                    idx--;
                    flag = false;
                }
            } else{
                if(idx>0) idx--;
                else if(idx == 0){
                    idx++;
                    flag = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str:ans){
            sb.append(str);
        }
        return sb.toString();
    }
}