class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String ans = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int max = 0;
        HashSet<String> set = new HashSet<String>();
        for(String s : banned){
            set.add(s.toLowerCase());
        }
        
        //only letters O(n)
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
        
        int i = 0;
        while(i < paragraph.length()){
            while(i < paragraph.length() && paragraph.charAt(i) == ' '){
                i++;
            }
            if(i >= paragraph.length()) break;
            
            int j = i;
            while(j < paragraph.length() && paragraph.charAt(j) != ' '){
                j++;
            }
            
            String tmp = paragraph.substring(i, j).toLowerCase();
            i = j;
            if(!set.contains(tmp)){
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                if(map.get(tmp) > max){
                    max = map.get(tmp);
                    ans = tmp;
                }
            }
            
            
        }
        
        
        return ans;
    }
}
