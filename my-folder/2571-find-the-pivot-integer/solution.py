class Solution(object):
    def pivotInteger(self, n):
        """
        :type n: int
        :rtype: int
        """
        if(n == 1): return 1
        l = 0
        r = n * (n + 1) // 2

        for i in range(1, n):
            l += i
            r -= (i - 1)
            
            if l == r:
                return i
        
        return -1
