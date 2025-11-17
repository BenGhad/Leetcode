class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        lMax = 0
        rMax = 0
        
        ans = 0
        while l <= r:
            if height[l] <= height[r]:
                if height[l] >= lMax:
                    lMax = height[l]
                else:
                    ans += lMax - height[l]
                l += 1
            else:
                if height[r] >= rMax:
                    rMax = height[r]
                else:
                    ans += rMax - height[r]
                r -= 1
        
        return ans

