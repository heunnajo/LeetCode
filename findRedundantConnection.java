class Solution {
    int n;
    int[] parent;
    int find(int x){
        if(x == parent[x]){
            return x;
        } else{
            return parent[x] = find(parent[x]);
        }
    }
    void union(int x,int y){
        //parent[y] = x;
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        parent = new int[n+1];
        
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
            if(find(edges[i][0]) == find(edges[i][1])){
                ans = edges[i];
            }
            union(edges[i][0],edges[i][1]);
        }
        
        return ans;
    }
}