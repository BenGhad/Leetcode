class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        boolean dot = false;
        boolean exp = false; // have we Ed

        char first = s.charAt(0);
        if (first == '+' || first == '-') {
            if (n == 1) {
                return false;
            }
        } else if (first == 'E' || first == 'e') {
            return false;
        } else if (first == '.') {
            if (n == 1) {
                return false;
            }
            if (!Character.isDigit(s.charAt(1))) {
                return false;
            }
            dot = true;
        } else if (!Character.isDigit(first)) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            char prev = s.charAt(i - 1);
            char next = (i < n - 1) ? s.charAt(i + 1) : 0;

            if (c == '+' || c == '-') {
                if (prev != 'e' && prev != 'E') {
                    return false;
                }
                if (!Character.isDigit(next)) {
                    return false;
                }

            } else if (c == 'e' || c == 'E') {
                if (prev == '.' || Character.isDigit(prev)) {
                    if (!Character.isDigit(next) && next != '+' && next != '-') {
                        return false;
                    }
                } else {
                    return false;
                }
                if(exp){
                    return false;
                }
                exp = true;
            } else if (c == '.') {
                if (exp) {
                    return false;
                }
                if (!Character.isDigit(prev) && !Character.isDigit(next)) {
                    return false;
                }
                if (dot) {
                    return false;
                }
                if (!Character.isDigit(prev) && !Character.isDigit(next)) {
                    return false;
                }
                dot = true;

            } else if (!Character.isDigit(c)) {
                return false;
            }

        }

        return true;
    }
}
