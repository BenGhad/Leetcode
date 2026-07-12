class Solution(object):
    def minSetSize(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        freq = defaultdict(int)
        for num in arr:
            freq[num] += 1
        

        values = sorted(freq.values())

        sz = 0
        cout = 0
        while sz < len(arr) // 2:
            sz += values.pop()
            cout += 1
        
        return cout

