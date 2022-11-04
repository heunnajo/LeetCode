//69. Sqrt(x)

class Solution {
    public int mySqrt(int x) {
        long low =  0;
        long high = x;
        long ans = 0;
        while(low <= high){
            long mid = (low+high)/2;
            if(mid*mid < x){
                low = mid + 1;
                ans = mid;
            }
            else if(mid*mid > x){
                high = mid - 1;
            }
            else{//정답 찾은 경우 바로 mid를 리턴
                return (int)mid;
            }
        }
        return (int)ans;
    }
}