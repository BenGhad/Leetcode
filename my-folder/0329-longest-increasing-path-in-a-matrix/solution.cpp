class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int ans = 1;
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> ll(
            n, vector<int>(m, 1)); // ll[i][j] = length of longest ENDING here

        queue<pair<int, int>> q;
        pair<int, int> dirs[] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ll[i][j] == 1) {
                    q.push(make_pair(i, j));

                    while (!q.empty()) {
                        auto [a, b] = q.front();
                        q.pop();

                        for (auto [dx, dy] : dirs) {
                            int ax = a + dx;
                            int by = b + dy;

                            if (ax < n && ax >= 0 && by >= 0 && by < m &&
                                matrix[ax][by] > matrix[a][b] &&
                                ll[ax][by] < ll[a][b] + 1) {
                                ll[ax][by] = ll[a][b] + 1;
                                ans = max(ans, ll[ax][by]);
                                q.push(make_pair(ax, by));
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
};
