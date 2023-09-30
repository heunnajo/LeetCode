import java.util.*;
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],10001);
            dist[i][i] = 0;
        }
        //연결 정보 저장
        for(int i=0;i<edges.length;i++){
            dist[edges[i][0]][edges[i][1]] = dist[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        
        int min = n;
        int ans = -1;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(dist[i][j] <= distanceThreshold) cnt++;
            }
            if(cnt <= min){//같은 경우 큰 번호를 취해야하기 때문에 등호가 포함되야함!
                ans = i;
                min = cnt;
            }
        }
        return ans;
    }
}