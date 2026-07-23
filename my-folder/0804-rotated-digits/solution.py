class Solution:
    def valid(self, num: int):
        yummy = False
        bluds = [0, 1, 8]
        yay = [2, 5, 6, 9]
        while num > 0:
            dig = num % 10
            
            if dig in yay:
                yummy = True
            elif dig not in bluds:
                return False
            num = num // 10
        
        
        return yummy
            
    def rotatedDigits(self, n: int) -> int:
        ans = 0
        
        for num in range(1, n+1):
            if self.valid(num):
                ans += 1
                
        return ans
