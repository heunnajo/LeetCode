import java.util.*;
class Solution {
    int INF = Integer.MAX_VALUE;
    class Node implements Comparable<Node>{
        int node,cost;
        Node(int node,int cost){
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node n){
            return this.cost - n.cost;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],INF);
            dist[i][i] = 0;
        }
        
        ArrayList<Node>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] e:edges){
            adj[e[0]].add(new Node(e[1],e[2]));
            adj[e[1]].add(new Node(e[0],e[2]));
        }
        
        for(int i=0;i<n;i++){
            dijkstra(i,n,dist[i],adj);
        }
        
        int min = n;
        int ans = -1;
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i == j) continue;
                if(dist[i][j] <= distanceThreshold) cnt++;
            }
            if(cnt <= min){
                ans = i;
                min = cnt;
            }
        }
        return ans;
    }
    void dijkstra(int st,int n,int[] dist,ArrayList<Node>[] adj){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(st,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(Node next:adj[cur.node]){
                if(dist[next.node] > dist[cur.node]+next.cost){
                    dist[next.node] = dist[cur.node]+next.cost;
                    pq.offer(new Node(next.node,dist[next.node]));
                }
            }
        }
    }
}