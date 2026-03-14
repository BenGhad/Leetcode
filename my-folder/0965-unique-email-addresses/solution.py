class Solution:
    def legit(self, email: str) -> str:
        fields = email.split("@")
        if len(fields) != 2: return ""
        
        local = fields[0]
        dom = fields[1]
        
        mail = ""
        for f in local:
            if f == '.': continue
            if f == '+': break
            mail += f
        return mail + "@" + dom
        
    
    def numUniqueEmails(self, emails: List[str]) -> int:
        ans = 0
        dupes = set()
        idk = ""
        dupes.add(idk)
        for email in emails:
            if Solution.legit(self, email) not in dupes:
                ans += 1
                dupes.add(Solution.legit(self, email))
        return ans
