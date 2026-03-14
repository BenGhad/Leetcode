class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        freq = defaultdict(int)
        house = []

        for num in nums:
            if freq[num] == 0:
                house.append(num)
            freq[num] += 1
        
        house = sorted(house)
        
        take = [-1 for _ in house]
        nah = [-1 for _ in house]

        take[0] = house[0] * freq[house[0]]
        nah[0] = 0
        ans = take[0]

        for i in range(1, len(house)):
            """
            i, i-1 conflict: classic hosue
            take[i] = nah[i-1] + val[i]
            nah[i] = prev[i-1]

            i, i-1 :D
            take[i] = take[i-1] + val[i]
            nah[i] = prev[i-1]
            """
            take[i] = house[i] * freq[house[i]]
            take[i] += nah[i-1] if house[i] - house[i-1] == 1 else max(nah[i-1], take[i-1])

            nah[i] = max(take[i-1], nah[i-1])
            ans = max(ans, take[i], nah[i])
        
        return ans
