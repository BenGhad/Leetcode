class Solution {
public:
    int bNum(const string& s) {
        int ans = 0;
        for (char c : s) ans = ans * 10 + (c - '0');
        return ans;
    }

    int openLock(vector<string>& deadends, string target) {
        unordered_set<int> dead;
        for (const string& s : deadends) dead.insert(bNum(s));

        int start = 0;
        int targ = bNum(target);

        if (dead.contains(start)) return -1;
        if (start == targ) return 0;

        queue<int> q;
        q.push(start);
        dead.insert(start);

        int dist = 0;

        while (!q.empty()) {
            int sz = q.size();
            while (sz--) {
                int cur = q.front();
                q.pop();

                if (cur == targ) return dist;

                for (int p = 1; p <= 1000; p *= 10) {
                    int digit = (cur / p) % 10;

                    int up = (digit != 9) ? cur + p : cur - 9 * p;
                    int down = (digit != 0) ? cur - p : cur + 9 * p;

                    if (!dead.contains(up) && !dead.contains(up)) {
                        dead.insert(up);
                        q.push(up);
                    }

                    if (!dead.contains(down) && !dead.contains(down)) {
                        dead.insert(down);
                        q.push(down);
                    }
                }
            }
            dist++;
        }

        return -1;
    }
};
