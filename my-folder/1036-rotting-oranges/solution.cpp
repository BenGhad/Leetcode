class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        vector<vector<bool>> vis(n, vector<bool>(m));
        queue<pair<int, int>> q;
        int t = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cell = grid[i][j];

                if (cell == 2) {
                    vis[i][j] = true;
                    q.push(make_pair(i, j));
                }

                if (cell == 1)
                    t++;
            }
        }

        int time = 0;

        pair<int, int> dirs[] = {make_pair(1, 0), make_pair(-1, 0),
                               make_pair(0, -1), make_pair(0, 1)};

        while (!q.empty()) {
            time++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                auto [x, y] = q.front();
                q.pop();

                for (auto [dx, dy] : dirs) {
                    int xp = x + dx;
                    int yp = y + dy;

                    if (xp >= 0 && yp >= 0 && xp < n && yp < m &&
                            grid[xp][yp] == 1 && !vis[xp][yp]) {
                        vis[xp][yp] = true;
                        q.push(make_pair(xp, yp));
                        t--;
                    }
                }
            }

            if(q.empty()) time--; 
        }

        return t == 0 ? time : -1;
    }
};
