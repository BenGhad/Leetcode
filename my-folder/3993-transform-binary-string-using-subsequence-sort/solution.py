class Solution:
    def transformStr(self, s: str, strs: List[str]) -> List[bool]:
        ans = []
        # am I stupid or
        # it's just "shifting ones" as far as 

        """
        011

        101 1 -> that

        010
        101 -> bad count

        js place ones at end I think
        1-> no<-

        can always have a 0 if
        """
        pref = []
        for c in s:
            if pref:
                pref.append(pref[-1] + (c == '1'))                
            else:
                pref.append(0 + (c == '1'))

        sOnes = pref[-1]
            

        for str in strs:
            str = list(str)
            zeros = 0
            ones = 0
            qs = 0
            for c in str:
                if c == '1':
                    ones += 1 
                elif c == '0':
                    zeros += 1
                else:
                    qs += 1

            if sOnes - (ones + qs) > 0 or (sOnes - ones < 0):
                ans.append(False)
                continue

            n = len(str)
            for i in range(n-1, -1, -1):
                if str[i] == '?':
                    if sOnes - ones > 0:
                        str[i] = '1'
                        ones += 1
                    else:
                        str[i] = '0'


            # we have # of 1s and 0s ok :DDD
            # can always bring a zero here but never a one  <---- 
            ones = 0
            good = True
            for i in range(n):
                ones += (str[i] == '1')
                if ones > pref[i]:
                    good = False
                    break
            ans.append(good)
        
        return ans
                
                
            
