class Solution {
    public int bulbSwitch(int n) {
        int count=0;
        for(int i=1; i<=n; i++){
            int numSwitch = helper(i);
            if(numSwitch%2 ==1)
                count++;
        }
     
        return count;
    }
     
    public int helper(int n){
        int count=0;
        for(int i=1; i<=n; i++){
            if(n%i==0)
                count++;
        }
        return count;
    }
}