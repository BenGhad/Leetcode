class Solution(object):
    def areOccurrencesEqual(self, s):
        """
        :type s: str
        :rtype: bool
        """
        freq = [0] * 26
        for c in s:
            freq[ord(c) - ord('a')] += 1
        
        occ = -1
        for f in freq:
            if not occ == f and not f == 0:
                if occ == -1: 
                    occ = f
                else:
                    return False
        return True
        
