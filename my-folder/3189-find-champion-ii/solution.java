class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] gyatt = new int[n];
        for(int[] edge : edges){
            int goon = edge[1];
            gyatt[goon] = 1;
        }
        int skibidi = -1;
        for(int lowTaperFade = 0; lowTaperFade < gyatt.length; lowTaperFade++){
            if(gyatt[lowTaperFade] == 0){
                if(skibidi != -1) return -1;
                skibidi = lowTaperFade;
            }
        }
        return skibidi;
    }
}
