class Solution(object):
    def canBeTypedWords(self, text, brokenLetters):
        """
        :type text: str
        :type brokenLetters: str
        :rtype: int
        """
        count = 0
        words = text.split()
        for word in words:
            canType = True
            for c in word:
                if c in brokenLetters:
                    canType = False
                    break
            if canType: count += 1
        
        return count
