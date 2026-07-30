class Solution:
    def minimumPushes(self, word: str) -> int:
        disc = defaultdict(int)
        for c in word:
            disc[c] += 1
        
        ans = 0
        
        vals = sorted(disc.values())
        
        cout = 1
        while vals:
            for _ in range(8):
                if vals:
                    vals.pop()
                    ans += cout
            cout += 1
        return ans
