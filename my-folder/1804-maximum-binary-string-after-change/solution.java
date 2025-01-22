class Solution {
    public String maximumBinaryString(String binary) {
        StringBuilder sb = new StringBuilder(); 
        int n = binary.length();
        int idx = 0;
        while (idx < n && binary.charAt(idx) == '1') {
            sb.append("1");
            idx++;
        }

        int ones = 0;
        for (int i = idx; i < n; i++) {
            if (binary.charAt(i) == '1')
                ones++;
        }

        for (int i = idx; i < n - ones - 1; i++) {
            sb.append("1");
        }
        if (ones + idx != n)
            sb.append("0");
        for (int i = n - ones; i < n; i++) {
            sb.append("1");
        }
        return sb.toString();
    }
}
