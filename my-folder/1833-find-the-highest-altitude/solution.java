class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAlt = 0;
        for(int i = 0; i < gain.length; i++){
            altitude += gain[i];
            maxAlt = Math.max(altitude, maxAlt);
        }
        return maxAlt;
    }
}
