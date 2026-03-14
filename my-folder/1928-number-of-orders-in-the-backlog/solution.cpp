class Solution {
public:
    int MOD = 1000000007;

    void addToSet(set<pair<int, int>>& s, int p, int a) {
        auto it = s.find({p, a});
        if (it != s.end()) {
            s.erase(it);
            s.insert({p, a + a});
        } else {
            s.insert({p, a});
        }
    }

    int getNumberOfBacklogOrders(vector<vector<int>>& orders) {
        set<pair<int, int>> sell;
        set<pair<int, int>> buy;

        for (auto& o : orders) {
            int p = o[0];
            int amount = o[1];
            int ot = o[2];

            if (ot == 0) { // buy
                while (amount > 0 && !sell.empty()) {
                    auto [sp, sa] = *sell.begin();

                    if (p < sp)
                        break;
                    int traded = min(amount, sa);
                    sa -= traded;
                    amount -= traded;

                    sell.erase(sell.begin());
                    if (sa != 0) {
                        addToSet(sell, sp, sa);
                    }
                }

                if (amount > 0) {
                    addToSet(buy, p, amount);
                }
            } else {
                while (amount > 0 && !buy.empty()) {
                    auto [bp, ba] = *prev(buy.end());

                    if (p > bp)
                        break;
                    int traded = min(amount, ba);
                    ba -= traded;
                    amount -= traded;

                    buy.erase(prev(buy.end()));
                    if (ba != 0) {
                        addToSet(buy, bp, ba);
                    }
                }

                if (amount > 0) {
                    addToSet(sell, p, amount);
                }
            }
        }

        int ans = 0;
        for (auto const& [p, a] : sell) {
            ans = (ans + a) % MOD;
        }
        for (auto const& [p, a] : buy) {
            ans = (ans + a) % MOD;
        }

        return ans;
    }
};
