class Solution(object):
    def countDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        count = 0
        number = num
        while number > 0:
            digit = number % 10
            count += 1 if num % digit == 0 else 0
            number /= 10
        return count
        
