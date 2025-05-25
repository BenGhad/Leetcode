class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        boolean mid = false;
        int count = 0;

        for(String key : map.keySet()){
            if(map.get(key) == 0) continue;
            String reverse = new StringBuilder(key).reverse().toString();
            
            if(key.equals(reverse)){
                int chose = (map.get(key) / 2) * 2;
                if(map.get(key) % 2 != 0 && !mid){
                    mid = true;
                    chose++;
                }

                count += 2 * chose;
                map.put(key, 0);
            } else if(map.containsKey(reverse)) {
                int pairs = Math.min(map.get(key), map.get(reverse));
                count += pairs * 4;
                map.put(key, 0);                
            }
         
        }

        return count;
    }

    
}
