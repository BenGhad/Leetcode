class MedianFinder:

    def __init__(self):
        self.smol = []
        self.big = []
        

    def addNum(self, num: int) -> None:
        if not self.big or num >= self.big[0]:
            heapq.heappush(self.big, num)
        else:
            heapq.heappush(self.smol, -num)
        
        while len(self.big) > len(self.smol):
            heapq.heappush(self.smol, (-1) * heapq.heappop(self.big))
            
        while len(self.smol) > len(self.big):
            heapq.heappush(self.big, -heapq.heappop(self.smol))

    def findMedian(self) -> float:
        if len(self.smol) > len(self.big):
            return self.smol[0] * -1
        if len(self.big) > len(self.smol):
            return self.big[0]
        
        return (-self.smol[0] + self.big[0]) / 2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
