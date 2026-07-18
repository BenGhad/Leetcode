class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates = sorted(candidates)

        _, ans = self.dfs(candidates, 0, target)
        
        return ans
    
    def dfs(self, candidates: List[int], idx : int, target : int) -> (bool, List[List[int]]):
        # Base case:
        if target == 0:
            return True, [[]]
        if idx == len(candidates):
            return False, []
        
        # sorted, so if can't take then can never take again
        if candidates[idx] > target:
            return False, []

        ans = []

        cnt = 0
        while cnt * candidates[idx] <= target:
            suc, take = self.dfs(candidates, idx + 1, target - (cnt *candidates[idx]))
            

            if suc:
                for ls in take:
                    ans.append(ls + [candidates[idx]] * cnt)
            
            cnt += 1

        
        return True,ans
