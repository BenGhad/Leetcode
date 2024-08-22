class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        Object[][] tuples = new Object[score.length][2];
        for(int i = 0; i < score.length; i++){
            tuples[i][0] = i;
            tuples[i][1] = score[i];
        }

        Arrays.sort(tuples, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return ((Comparable) o2[1]).compareTo(o1[1]);
            }
        });

        for (int i = 0; i < tuples.length; i++) {
            int index = (int) tuples[i][0];
            if (i == 0) {
                ans[index] = "Gold Medal";
            } else if (i == 1) {
                ans[index] = "Silver Medal";
            } else if (i == 2) {
                ans[index] = "Bronze Medal";
            } else {
                ans[index] = String.valueOf(i + 1);  // Properly convert int to string
            }
        }

        return ans;
        
    }
}
