class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        negs = []
        pos = []
        
        for num in nums:
            if num < 0:
                negs.append(num * num)
            else:
                pos.append(num * num)
                
        ans = []
        
        n = len(negs) - 1
        p = 0
        
        
        while p < len(pos) and n >= 0:
            if negs[n] < pos[p]:
                ans.append(negs[n])
                n -= 1
            else:
                ans.append(pos[p])
                p += 1
                
        while p < len(pos):
            ans.append(pos[p])
            p += 1
        
        while n >= 0:
            ans.append(negs[n])
            n -= 1
        
        return ans
