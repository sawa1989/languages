class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] x = {1, -1, 0, 0};
        int[] y = {0,0,1,-1};
        
        int max_x = board[0].length;
        int max_y = board.length;
        
        for(int i=0;i<4;i++){
            int new_x = w+x[i];
            int new_y = h+y[i];
            
            if(new_x <0 || new_y <0 || new_x >= max_x || new_y >=max_y){
                continue;
            }
            
            
            if(board[new_y][new_x].equals(board[h][w])){
                answer++;
            }
        }
        
        return answer;
    }
}
