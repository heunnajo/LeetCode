import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> stack = new Stack<>();
        
         for(int i=0;i<tokens.length;i++){
            String cur = tokens[i];
             //1.operand
            if(!cur.equals("+") && !cur.equals("-") && !cur.equals("*") && !cur.equals("/")){
                int intCur = Integer.parseInt(cur);
                stack.push(intCur);
            } else{//2.operator : There must be more than 2 elements in stack.
                if(stack.size() >= 2){
                    int b = stack.pop();
                    int a = stack.pop();
                    int res = 0;
                    if(cur.equals("+")){
                        res = a + b;
                    } else if(cur.equals("-")){
                        res = a - b;
                    } else if(cur.equals("*")){
                        res = a * b;
                    } else if(cur.equals("/")){
                        res = a / b;
                    }
                    stack.push(res);
                }
            }
            
         }
        if(stack.isEmpty()) return 0;
        else return stack.pop();
    }
}