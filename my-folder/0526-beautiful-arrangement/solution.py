class Solution:
    def countArrangement(self, n: int) -> int:    
        
        dp = [[] for _ in range(n+1)]
        dp[1] = [{i} for i in range(1, n+1)]

        for i in range(2, n+1):
            for beu in dp[i-1]:
                for num in range(1, n+1):
                    if num in beu:
                        continue
                    
                    if i % num == 0 or num % i == 0:
                        dp[i].append(beu.copy())
                        dp[i][-1].add(num)



        for perm in dp[n]:
            for num in perm:
                print(str(num) + " ",end="")
            print("")

        return len(dp[n])
