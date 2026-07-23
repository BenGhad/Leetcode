class Solution:
    def checkRecord(self, s: str) -> bool:
        aa = 0
        lcs = 0
        
        for c in s:
            if c == 'A':
                aa += 1
                lcs = 0
                if aa >=2:
                    return False
            if c == 'L':
                lcs += 1
                if lcs >= 3:
                    return False
            else:
                lcs = 0
        return True
