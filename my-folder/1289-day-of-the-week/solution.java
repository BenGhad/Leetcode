class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int a = (14 - month) / 12;
        int y = year - a;
        int m = month + 12 * a - 2;
        int d = (day + y + y/4 - y/100 + y/400 + (31 * m) / 12) % 7;
        if (d == 0) return "Sunday";
        if (d == 1) return "Monday";
        if (d == 2) return "Tuesday";
        if (d == 3) return "Wednesday";
        if (d == 4) return "Thursday";
        if (d == 5) return "Friday";
        return "Saturday";
    }
}

