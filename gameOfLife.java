class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveNBR = getLiveNBR(m,n,i,j,board);
                
                if(board[i][j] == 1 && (liveNBR == 2 || liveNBR == 3)){
                //if(board[i][j] == 1 && liveNBR >= 2 && liveNBR <= 3){
                    board[i][j] = 3;
                } else if(board[i][j] == 0 && liveNBR == 3) {
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] >>= 1;
            }
        }
    }
    int getLiveNBR(int m,int n,int x,int y,int[][] board){
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        int liveSum = 0;
        //(x,y) 기준 8개 이웃칸들 탐색
        for(int d=0;d<8;d++){
            int nx = x+dx[d]; int ny = y+dy[d];
            if(isOut(nx,ny,m,n)) continue;
            liveSum += (board[nx][ny] & 1);
        }
        return liveSum;
    }
    boolean isOut(int x,int y,int row,int col){
        return x<0 || x>=row || y<0 || y>=col;
    }
}