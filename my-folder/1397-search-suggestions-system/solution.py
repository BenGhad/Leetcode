class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        best = []
        products = sorted(products)
        pq = []
        for p in products:
            if len(best) < 3 and p[0] == searchWord[0]:
                best.append(p)
            else:
                heapq.heappush(pq, p)
        
        ans = []
        x = len(searchWord)
        for i in range(x):
            # pref:
            pref = searchWord[:i+1]
            #new best
            best = [b for b in best if b.startswith(pref)]

            while len(best) < 3 and pq:
                cand = heapq.heappop(pq)
                if cand.startswith(pref):
                    best.append(cand)
            
            ans.append(best.copy())

        return ans

        
