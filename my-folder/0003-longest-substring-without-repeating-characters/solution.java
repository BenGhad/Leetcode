class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        int low = 0;
        int high = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) >= low){
                    low = map.get(s.charAt(i)) + 1;
                }
            }
            map.put(s.charAt(i), i);
        
            count = Math.max(high - low + 1, count);
            high++;
        }
        return count;
    }
}
