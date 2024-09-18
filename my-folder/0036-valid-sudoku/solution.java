class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] arr = new int[9];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){ continue;}
                int c = Character.getNumericValue(board[i][j]);
                if(arr[c - 1] == 1){
                    return false;
                }
                arr[c-1] = 1;
            }
            arr = new int[9];
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][i] == '.'){ continue;}
                int c = Character.getNumericValue(board[j][i]);
                if(arr[c - 1] == 1){
                    return false;
                }
                arr[c-1] = 1;
            }
            arr = new int[9];
        }
        
        for(int box = 1; box < 10; box++){
            int col = 1 + 3 * ((box - 1) % 3);
            int row = 1 + 3 * ((box - 1) / 3);
            for(int i = col - 1; i < col + 2; i++){
                for(int j = row - 1; j < row + 2; j++){
                    if(board[j][i] == '.'){continue;}
                    int c = Character.getNumericValue(board[j][i]);
                    if(arr[c - 1] == 1){return false;}
                    arr[c-1] = 1;
                }
            }

            arr = new int[9];
        }




        return true;
        
    }
}
