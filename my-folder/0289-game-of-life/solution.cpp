class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        vector<pair<int, int>> directions = {
            {-1, -1}, // up-left
            {-1, 0},  // up
            {-1, 1},  // up-right
            {0, -1},  // left
            {0, 1},   // right
            {1, -1},  // down-left
            {1, 0},   // down
            {1, 1}    // down-right
        };

        int m = board.size();
        int n = board[0].size();

        for (auto& row : board) {
            for (auto& col : row) {
                col++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cell = board[i][j];
                int neighbor = 0;
                for (pair<int, int> direction : directions) {
                    int dx = i + direction.first;
                    int dy = j + direction.second;
                    if (dx >= 0 && dx < m && dy >= 0 && dy < n &&
                        abs(board[dx][dy]) == 2) {
                        neighbor++;
                    }
                }
                // dead
                if (board[i][j] == 1) {
                    if (neighbor == 3) {
                        board[i][j] = -1;
                    }
                } else if (board[i][j] == 2) { // alive
                    if (neighbor < 2 || neighbor > 3) {
                        board[i][j] = -2;
                    }
                }
            }
        }

        // update and revert
        for (auto& row : board) {
            for (auto& col : row) {
                if (col < 0) {
                    col += 3;
                }
                col--;
            }
        }
    }
};
