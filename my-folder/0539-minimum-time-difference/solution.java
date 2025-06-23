class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] mins = new int[timePoints.size()];

        for(int i = 0; i < timePoints.size(); i++){
            String s = timePoints.get(i);
            int hours = Integer.parseInt(s.substring(0, 2));
            int minutes = Integer.parseInt(s.substring(3));
            mins[i] = hours * 60 + minutes;
        }
        Arrays.sort(mins);
        
        int min = (mins[0] - mins[mins.length - 1] + 1440) % 1440;
        for(int i = 0; i < mins.length - 1; i++){
            min = Math.min(min, mins[i + 1] - mins[i]);
        }

        return min;
    }
}
