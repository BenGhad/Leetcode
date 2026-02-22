class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n = len(temperatures)
        ans = [0] * n
        hawt = [] # idx of temps
        
        for i in range(n):
            while len(hawt) != 0 and temperatures[i] > temperatures[hawt[-1]]:
                ansI = hawt.pop()
                ans[ansI] = (i - ansI)

            hawt.append(i)
        
        return ans
