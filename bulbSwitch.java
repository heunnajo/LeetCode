class Solution {
    public int bulbSwitch(int n) {
        
        int[] bulbs = new int[n+1];
        
        int round;
        for(int i=1;i<=n;i++){//n round를 반복한다!
            round = i;
            
            while(round<=n){
                bulbs[round] = 1 - bulbs[round];
                round = round+i;
            }
        }
        
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(bulbs[i] == 1) ans++;
        }
        
        return ans;
    }
}