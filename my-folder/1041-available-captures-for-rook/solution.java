class Solution {
    public int numRookCaptures(char[][] board) {
       int rookRow = 0, rookCol = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break;
                }
            }
        }

        int c = 0;


        for (int i = rookRow - 1; i >= 0; i--) {
            if (board[i][rookCol] == 'B') break; // Blocked by a bishop
            if (board[i][rookCol] == 'p') {
                c++;
                break; // Stop after capturing
            }
        }

        for (int i = rookRow + 1; i < board.length; i++) {
            if (board[i][rookCol] == 'B') break; // Blocked by a bishop
            if (board[i][rookCol] == 'p') {
                c++;
                break; // Stop after capturing
            }
        }

        for (int j = rookCol - 1; j >= 0; j--) {
            if (board[rookRow][j] == 'B') break; // Blocked by a bishop
            if (board[rookRow][j] == 'p') {
                c++;
                break; // Stop after capturing
            }
        }

        for (int j = rookCol + 1; j < board[0].length; j++) {
            if (board[rookRow][j] == 'B') break; // Blocked by a bishop
            if (board[rookRow][j] == 'p') {
                c++;
                break; // Stop after capturing
            }
        } 



        return c;
    }
}
