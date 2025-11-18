class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        ans = []
        tIdx = 0
        for i in range(1, target[-1] + 1):
            ans.append("Push")
            if i == target[tIdx]:
                tIdx += 1
            else:
                ans.append("Pop")
        return ans
