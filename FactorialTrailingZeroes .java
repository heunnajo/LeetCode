class Solution {
    public int trailingZeroes(int n) {
        int fact = 1;//test로 임의로 int타입
        for(int i=1;i<=n;i++){
            fact *= i;
        }
        System.out.println(fact);
        String strFact = fact+"";
        int ans = 0;
        if(strFact.charAt(strFact.length()) == '0'){
            ans++;
        }
    }
}