class Solution(object):
    def getNoZeroIntegers(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        for i in range(1, n):
            if safe(i) and safe(n - i):
                return [i, n - i]
        return [-1, -1]

def safe(n):
    if n == 0: return True
    return False if n % 10 == 0 else safe(n / 10) 
