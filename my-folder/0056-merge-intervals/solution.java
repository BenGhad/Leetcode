class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] i1 = intervals[i];
            int[] i2 = intervals[i + 1];
            if (i1[0] <= i2[0] && i2[0] <= i1[1]) {
                int[] merged = mergeInterval(i1, i2);
                intervals[i + 1] = merged;
            } else {
                list.add(i1);
            }
        }
        list.add(intervals[intervals.length - 1]);

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] mergeInterval(int[] a, int[] b) {
        return new int[] {
                Math.min(a[0], b[0]),
                Math.max(a[1], b[1])
        };
    }
}
