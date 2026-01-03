class Solution(object):
    MOD = 1000000007
    nabc = {}
    naba = {}

    def numOfWays(self, n):        
        if n == 1:
            return 12

        ans = (Solution.numOfABC(self, n) + Solution.numOfABA(self, n)) % Solution.MOD

        return (ans * 6) % Solution.MOD
        

    def numOfABC(self, n):
        if n in Solution.nabc:
            return Solution.nabc[n]
            
        if n == 1:
            return 1

        ans = ((Solution.numOfABA(self, n -1) * 2) + (Solution.numOfABC(self, n - 1) * 2)) % Solution.MOD
        Solution.nabc[n] = ans

        return ans

    def numOfABA(self, n):
        if n in Solution.naba:
            return Solution.naba[n]

        if n == 1:
            return 1
        
        ans = ((Solution.numOfABA(self, n-1)) * 3 % Solution.MOD 
        + (Solution.numOfABC(self, n-1) * 2)) % Solution.MOD

        Solution.naba[n] = ans
        return ans


    
        
