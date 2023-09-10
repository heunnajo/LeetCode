import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    class Pair {
		int idx, dist;//dist는 제곱의 합의 형태로 비교.
		
		Pair(int idx,int dist){
			this.idx = idx;
			this.dist = dist;
		}
	}
    public int[][] kClosest(int[][] points, int K) {
        List<Pair> list = new ArrayList<>();
		
		for(int i=0;i<points.length;i++) {
			list.add(new Pair(i,points[i][0]*points[i][0]+points[i][1]*points[i][1]));
		}
		Comparator<Pair> comp = new Comparator<Pair>() {
			@Override
			public int compare(Pair p1,Pair p2) {
				return p1.dist - p2.dist;
			}
		};
		Collections.sort(list,comp);
        int[][] answer = new int[K][2];
        for(int i=0;i<K;i++){
            answer[i] = points[list.get(i).idx];
        }
        return answer;
    }
}
