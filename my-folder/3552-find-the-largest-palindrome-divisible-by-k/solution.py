class Solution:
    def largestPalindrome(self, n: int, k: int) -> str:
        """
        1: 99999..
        2: 899998..
        3: 999999
        4: 88999988
        5: 59999995
        6: 
           n odd: 8 99 8 99 8
           n even: 8 9779  8
        7:
        8: 888 999999 888 
        9: 99999999
        """

        if k == 1:
           return "9" * n
        
        if k == 2:
            if n <= 2:
                return "8" * n
            return "8" + "9" * (n - 2) + "8"

        if k == 3:
            return "9" * n

        if k == 4:
            if n <= 4:
                return "8" * n
            return "88" + "9" * (n - 4) + "88"
        
        if k == 5:
            if n <= 2:
                return "5" * n
            return "5" + "9" * (n - 2) + "5"

        if k == 6:
            if n <= 2:
                return "6" * n

            if n % 2 == 1:
                # 8 9...9 8 9...9 8
                m = (n - 3) // 2
                return "8" + "9" * m + "8" + "9" * m + "8"
            else:
                # 8 9...9 77 9...9 8
                m = (n - 4) // 2
                return "8" + "9" * m + "77" + "9" * m + "8"
        
        if k == 7:
            centers = {
                1: "7",
                2: "77",
                3: "959",
                4: "9779",
                5: "99799",
                6: "999999",
                7: "9994999",
                8: "99944999",
                9: "999969999",
                10: "9999449999",
                11: "99999499999",
                0: ""
            }
            if n % 6 == 0:
                return "9" * n
            c = centers[n % 12]
            side = (n - len(c)) // 2
            return "9" * side + c + "9" * side

        if k == 8:
            if n <= 6:
                return "8" * n
            return "888" + "9" * (n - 6) + "888"

        if k == 9:
            return "9" * n

        return ""

