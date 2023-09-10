import java.util.Arrays;
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Comparator<int[]> comp = new Comparator<int[]>() {
			public int compare(int[] p1,int[] p2) {
				return p1[0]*p1[0]+p1[1]*p1[1] - p2[0]*p2[0]-p2[1]*p2[1];
			}
		};
		Arrays.sort(points,comp);
        return Arrays.copyOfRange(points,0,K);
		// for(int i=0;i<points.length;i++) {
		// 	System.out.println(points[i][0]+","+points[i][1]);
		// }
    }
}
