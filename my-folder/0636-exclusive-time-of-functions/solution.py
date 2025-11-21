class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        tim = [0 for _ in range(n)]
        funcs = []  # (id, current_start_time)

        for log in logs:
            num, mod, t = log.split(":")
            num = int(num)
            is_start = (mod == "start")
            t = int(t)

            if is_start:
                if funcs:
                    tim[funcs[-1][0]] += t - funcs[-1][1]
                funcs.append([num, t])
            else:
                prev, start_t = funcs.pop()
                tim[prev] += t - start_t + 1
                 
                if funcs:
                    funcs[-1][1] = t + 1

        return tim

