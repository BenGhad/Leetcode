class Solution {
    public int minTimeToType(String word) {
        char pt = 'a';
        int t= 0;
        for(char s : word.toCharArray()){
            t += Math.min(Math.abs(pt - s), 26 - Math.abs(pt - s));
            pt = s;
        }
        return t + word.length();
    }
}
