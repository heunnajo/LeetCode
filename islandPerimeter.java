import java.util.*;
class Solution {
    int Perimeter;
    int[][] Grid;
    int R,C;
    boolean[][] Visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int islandPerimeter(int[][] grid) {
        Grid = grid;
        R = Grid.length;
        C = Grid[0].length;
        Visited = new boolean[R][C];
        Perimeter = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(Grid[i][j] == 1 && !Visited[i][j]){
                    getPeri(i,j);
                }
            }
        }
        return Perimeter;
    }
    public void getPeri(int x,int y){
        Queue<Pair> q = new LinkedList<>();
        Visited[x][y] = true;
        q.offer(new Pair(x,y));

        while(!q.isEmpty()){
            Pair cur = q.poll();

            for(int d=0;d<4;d++){
                int nx = cur.x+dx[d]; int ny = cur.y+dy[d];

                if(isOut(nx,ny) || Grid[nx][ny] == 0) Perimeter++;//범위밖이거나 물(0)이면 1씩 증가.
                if(isOut(nx,ny) || Grid[nx][ny] != 1 || Visited[nx][ny]) continue;
                q.offer(new Pair(nx,ny));
                Visited[nx][ny] = true;
            }
        }
    }
    public boolean isOut(int x,int y){
        return x<0 || x>=R || y<0 || y>=C;
    }
}