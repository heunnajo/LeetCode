class Solution {//DFS
    int m,n;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        //error check
        if(board == null ||board.length == 0 || board[0].length == 0) {return false;}
        
        //creat and set value of data structure
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0 ; i<m ; i++) {
            for(int j=0; j<n ; j++) {
                if(dfs(board,visited,i,j,0,word)) {return true;}//계속 파고들어서 최종적으로 true이면 true를 리턴!
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, int x, int y, int index, String word) {
        if(index == word.length()) return true;
        if(x<0 || x>=m ||y<0 || y>=n) return false;
        if(visited[x][y]) return false;//한번 방문했던 것은 방문하지 않기 위함인것같은데 아래 코드에 의해 방문했더라도 false가되면서 무의미하게된다.
        if(board[x][y] != word.charAt(index)) return false;
        
        //board[x][y] == word.charAt(index) 선택받은 자들은 아래를 수행~!
        visited[x][y] = true;
        for(int[] dir:dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(dfs(board,visited,newX,newY,index+1,word)){//4방으로 돌린다. 리턴값 받아서 return true를 하는 거지!
                return true;
            }
        }
        visited[x][y] = false;//다시 안가기 위해 false를 저장하고, 앞서 호출한 곳에 false리턴한다!
        return false;
    }
}