class Solution:
    def countSequences(self, nums: List[int], k: int) -> int:
        def powFrac(x):
            e2=e3=e5=0
            while x%2==0: 
                e2 += 1
                x /= 2
            while x%3 == 0:
                e3 += 1
                x /= 3
            while x%5 == 0:
                e5 += 1
                x /= 5
            return e2, e3, e5, x
    
        e2,e3,e5,r = powFrac(k)
        if r != 1:
            return 0 
            
        dp = Counter({(0, 0, 0): 1})
        for num in nums:
            t, tr, f, rem = powFrac(num)
            nxt = Counter()
            for (tp, trp, fp), cnt in dp.items():
                nxt[(tp, trp, fp)] += cnt
                nxt[(tp+t, trp+tr, fp+f)] += cnt
                nxt[(tp-t, trp-tr, fp-f)] += cnt
            dp = nxt
        return dp[(e2,e3,e5)]
        
