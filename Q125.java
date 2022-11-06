//125. Valid Palindrome

import java.util.*;
class Solution {
    public boolean isPalindrome(String s) {
        //0.preprocessing
        int len = s.length();
        s = s.toLowerCase();
        //System.out.println("소문자변환후: "+s);
        
        StringBuilder sbd = new StringBuilder();//알파벳 or "숫자"인 것만 이어붙인다!
        for(int i = 0;i<len;i++){
            char cur = s.charAt(i);
            if('a' <= cur && cur <= 'z' || 0 <= cur-'0' && cur-'0' <= 9){
                sbd.append(cur);
            }
        }
        
        s = sbd.toString();
        //System.out.println("비알파벳 제거 후: "+s);
        
        //1.process depending on s.length()
        //System.out.println("s.length(): "+s.length());
        len = s.length();
        if(len % 2 != 0){
            int mid = len/2;
            for(int i=1;i<=mid;i++){
                if(s.charAt(mid-i) != s.charAt(mid+i)) return false;
            }
        } else{
            StringBuffer sb = new StringBuffer(s);
            String reversedS = sb.reverse().toString();

            if(!s.equals(reversedS)) return false;
        }
        return true;
    }
}