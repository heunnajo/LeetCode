class Solution {
    public int reverse(int x) {
        String strX = x + "";
        String reversed = new StringBuilder().append(x).reverse().toString();
        
        if(reversed.charAt(reversed.length()-1) == '-'){
            reversed = "-"+reversed.substring(0,reversed.length()-1);
        }
        if(reversed.charAt(reversed.length()-1) == '0'){
            reversed = reversed.substring(1);
        }
        if(Long.parseLong(reversed) >= Integer.MAX_VALUE || Long.parseLong(reversed) <= Integer.MIN_VALUE){
            return 0;
        } else{
            return Long.parseLong(reversed);
        }
        /*for(int i=strX.length()-1;i>=0;i--){
            reversed.append(strX.charAt(i));
        }
        String res = reversed.toString();
        if(strX.charAt(0) == '-'){
            res = "-"+res.substring(0,strX.length()-1);
        }
        if(strX.charAt(strX.length()-1) == '0'){
            res = res.substring(1);
        }
        System.out.println("res: "+res);
        int ans = Integer.parseInt(res);
        return ans;*/
        
    }
}