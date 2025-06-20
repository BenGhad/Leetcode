class Solution {
    public int maxDistance(String s, int k) {
        int[] p = new int[4];
        int max = -1;

        for(int i = 0; i < s.length(); i++){
            p[dirToNum(s.charAt(i))]++;
            int dist = Math.abs(p[0] - p[1]) + Math.abs(p[2] - p[3]);
            int khange = k;
            dist += Math.min(khange, Math.min(p[0], p[1]) + Math.min(p[2], p[3])) * 2;
            
            max = Math.max(max, dist);
        }
        return max;
    }

    public static int dirToNum(char c){
        if(c == 'N') return 0;
        if(c == 'S') return 1;
        if(c == 'E') return 2;
        if(c == 'W') return 3;

        return -1;
    }
}
