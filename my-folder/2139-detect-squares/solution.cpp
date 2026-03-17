class DetectSquares {
public:
    vector<vector<int>> grid = vector<vector<int>>(1001, vector<int>(1001, 0));
    pair<int, int> dirs[4] =  {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    DetectSquares() {

    }

    void add(vector<int> point) { grid[point[0]][point[1]]++; }

    int count(vector<int> point) {
        int answer = 0;
        int i = point[0], j = point[1];

        // +- 1 2 3 4
        for (auto [dx, dy] : dirs) {
            int x = point[0] + dx;
            int y = point[1] + dy;
            
            // always in bounds
            while (x >= 0 && x <= 1000 && y >= 0 && y <= 1000) {
                answer += grid[x][y] * grid[x][j] * grid[i][y];
                x += dx;
                y += dy;
            }
        }
        return answer;

    }
};

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares* obj = new DetectSquares();
 * obj->add(point);
 * int param_2 = obj->count(point);
 */
