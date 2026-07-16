class FreqStack:
    
    def __init__(self):
        self.stacks = []
        self.freq = defaultdict(int)


    def push(self, val: int) -> None:
        self.freq[val] += 1
        if self.freq[val] > len(self.stacks):
            self.stacks.append([val])
        else:
            self.stacks[self.freq[val] - 1].append(val)
    
    def pop(self) -> int:
        val = self.stacks[-1].pop()
        if not self.stacks[-1]:
            self.stacks.pop()
        self.freq[val]-=1
        return val    


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()
