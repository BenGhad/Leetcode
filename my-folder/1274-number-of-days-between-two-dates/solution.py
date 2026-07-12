class Solution:
    def effOfDate(date: str):
        # 1971 01 01
        year, month, day = map(int, date.split('-'))

        days = 0
        # Can be done in O(1) as / 4 + % 4 i believe
        for y in range(1971, year):
            if y % 4 == 0:
                days += 1
            days += 365
        
        
        daysInMonth = [
            '31', '28' if year % 4 != 0 else '29', '31', '30', '31', '30', '31', '31','30','31', '30', '31'
        ]
        for i in range(month-1):
            days += int(daysInMonth[i])
        
        days += day

        if year == 2100:
            days -= 1
        return days
        
        
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        return abs(Solution.effOfDate(date1) - Solution.effOfDate(date2))
        
