class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        nums = []
        ops = {
        "+": operator.add,
        "-": operator.sub,
        "*": operator.mul,
        "/": lambda a, b: int(a / b)
        }

        for t in tokens:
            if t not in ops:
                nums.append(t)
            else:
                a = int(nums.pop())
                b = int(nums.pop())
                nums.append(ops[t](b, a))

        return int(nums[-1])

            
            
