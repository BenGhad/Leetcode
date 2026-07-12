class Solution:
    
    def __init__(self, w: List[int]):
        self.n = len(w)
        self.weights = w
        self.prefW = [0 for _ in range(self.n)]
        self.sumW = sum(w)

        self.prefW[0] = w[0]
        for i in range(1, self.n):
            self.prefW[i] = self.prefW[i-1] + w[i]


    def pickIndex(self) -> int:
        idx = random.randint(1, self.sumW)

        l = 0
        r = self.n - 1
        cand = -1

        while l <= r:
            m = l + (r - l) // 2
            
            if self.prefW[m] >= idx:
                cand = m
                r = m - 1
            else:
                l = m + 1
        return cand

        


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()
