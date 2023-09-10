import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    class Pair implements Comparable<Pair> {
		int idx;
        int[] dist;//dist는 제곱의 합의 형태로 비교.
		
		Pair(int idx,int[] dist){
			this.idx = idx;
			this.dist = dist;
		}
		@Override
		public int compareTo(Pair p) {
			int[] a = this.dist;
			int[] b = p.dist;
			return a[0]*a[0]+a[1]*a[1] - b[0]*b[0]-b[1]*b[1];
		}
	}
    public int[][] kClosest(int[][] points, int K) {
       PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i=0;i<points.length;i++) {
			pq.offer(new Pair(i,points[i]));
		}
		
		int[][] answer=  new int[K][2];

		for(int i=0;i<K;i++) {
			answer[i] = points[pq.poll().idx];
			//System.out.println(answer[i][0]+","+answer[i][1]);
		}
		return answer;
    }
}
