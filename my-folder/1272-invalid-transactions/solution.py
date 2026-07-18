class Solution:
    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        ans = []
        
        for t1 in transactions:
            name, time, amt, city = t1.split(",")
            
            if int(amt) > 1000:
                ans.append(t1)
                continue
                
            for t2 in transactions:
                n2, t2, _, c2 = t2.split(",")
                
                if name == n2 and city != c2 and abs(int(time) - int(t2)) <= 60:
                    ans.append(t1)
                    break 
        return ans
