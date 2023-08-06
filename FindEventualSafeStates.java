import java.util.*;
public class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        //0. adjacent node info
        //1. find a terminal node
        int n = graph.length;
        int[][] adj = new int[n][n];
        ArrayList<Integer> tmList = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;i++){
                adj[i][graph[i][j]] = 1;
            }
            if(graph[i].length == 0){
                tmList.add(i);
            }
        }
        //2. find a safe node
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int x:tmList){
                if(adj[i][x] == 1 ){ans.add(i);}
            }
        }
        for(int x:tmList){
            ans.add(x);
        }
        Collections.sort(ans);
        return ans;
    }
}