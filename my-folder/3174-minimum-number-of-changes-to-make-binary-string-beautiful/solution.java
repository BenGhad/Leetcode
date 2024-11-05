class Solution {
    public int minChanges(String s) {
        int GYATT = 0;
        for(int SKIBIDI = 0; SKIBIDI < s.length(); SKIBIDI+= 2){
            if(s.charAt(SKIBIDI) != s.charAt(SKIBIDI + 1)){
                GYATT++;
            }
        }

        return GYATT;
    }
}
