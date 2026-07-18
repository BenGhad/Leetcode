class Solution:
    def minimumDeletions(self, s: str) -> int:
        ans = float('inf')

        pref = [0]

        for c in s:
            if c == 'a':
                pref.append(pref[-1] + 1)
            else:
                pref.append(pref[-1])
        
        suf = [0]
        for i in range(len(s) - 1, -1, -1):
            if s[i] == 'a':
                suf.append(suf[-1] + 1)
            else:
                suf.append(suf[-1])
        
        suf.reverse()

        # pref[i] = up to I no include
        # suf[i] = after I no include


        for i in range(0, len(s)+1):
            b = i - pref[i]
            ans = min(ans, b + suf[i])
            
        return ans
