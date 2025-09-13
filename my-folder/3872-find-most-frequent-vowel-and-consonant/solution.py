class Solution(object):
    def maxFreqSum(self, s):
        """
        :type s: str
        :rtype: int
        """
        vowels = {'a':0, 'e':0, 'i':0, 'o':0, 'u': 0}
        cons = {}

        for c in s:
            if c in vowels:
                vowels[c] += 1
            elif c in cons:
                cons[c] += 1
            else:
                cons[c] = 1

        return max(vowels.values()) + (max(cons.values()) if cons else 0)
        
