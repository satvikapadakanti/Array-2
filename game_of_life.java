class Solution {
    int[][] dirs;
    int m,n;
    public void gameOfLife(int[][] board) {
        this.dirs=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        this.m=board.length;
        this.n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count=countlives(board,i,j);
                if(board[i][j]==0 && count==3){
                    board[i][j]=3;
                }
                else if(board[i][j]==1 && (count<2 ||count>3)){
                    board[i][j]=2;
                }
            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }
                else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
            }
        
    }
    private int countlives(int[][] board,int i,int j){
        int count=0;
        for(int[] dir:dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n)
            if(board[nr][nc]==1 || board[nr][nc]==2){
                count++;
            }
        }
        return count;
    }
}