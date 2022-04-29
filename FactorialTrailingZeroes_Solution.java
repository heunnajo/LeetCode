
class Solution {
    public int trailingZeroes(int n) {
    
        int sol = 0;
        int expOfFive = 5;
        while(n >= expOfFive){//n=5, 5! = 1
            sol += n / expOfFive;
            expOfFive = 5 * expOfFive;
        }
        System.out.println(sol);
        return sol;
        
    }
}