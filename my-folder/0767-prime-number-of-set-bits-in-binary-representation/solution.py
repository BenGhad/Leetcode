class Solution(object):
    def countPrimeSetBits(self, left, right):
        """
        :type left: int
        :type right: int
        :rtype: int
        """
        ans= 0
        for i in range(left, right + 1):
            ans = ans + 1 if self.isPrimeSet(i) else ans
        
        return ans
    
    def isPrimeSet(self, n):
        cnt = 0
        while n > 0:
            if n % 2 != 0:
                cnt += 1
            n /= 2
        
        primes = [2,3, 5, 7, 11, 13, 17, 19]
        return cnt in primes
        
