class Solution(object):
    def largestGoodInteger(self, num):
        """
        :type num: str
        :rtype: str
        """
        n = len(num)
        good = ""
        for i in range(n - 2):
            if num[i] == num[i + 1] == num[i + 2]:
                good = max(good, num[i:i+3])
        return good
        
