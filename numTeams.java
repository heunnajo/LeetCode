class Solution {
    public int numTeams(int[] rating) {
        int leftBigger, rightLess;//desc
        int leftLess, rightBigger;//asc
        int ans = 0;
        
        for(int x=0;x<rating.length;x++){
            leftBigger = rightLess = leftLess = rightBigger = 0;
            
            for(int i=0;i<x;i++){
                if(rating[i]<rating[x]) leftLess++;
                if(rating[i]>rating[x]) leftBigger++;                   
            }
            
            for(int i=x+1;i<rating.length;i++){
                if(rating[x]<rating[i]) rightBigger++;
                if(rating[x]>rating[i]) rightLess++;//leftBigger++;
            }
            ans += leftBigger * rightLess + leftLess * rightBigger;
        }
        
        return ans;
    }
}