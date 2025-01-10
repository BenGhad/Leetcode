class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> ans = new ArrayList<>();
        int[] totalFreq = new int[26];

        for(String s : words2){
            int[] freq = new int[26];    
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                freq[c - 'a']++;
            }

            for(int i = 0; i < 26; i++){
                if(totalFreq[i] < freq[i]) totalFreq[i] = freq[i];
            }
        }


        //pt 2:
        for(String s : words1){
            int[] freq = new int[26];
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                freq[c - 'a']++;
            }
            
            boolean valid = true;
            for(int i = 0; i < 26; i++){
                if(totalFreq[i] > freq[i]){
                    valid = false;
                    break;
                }
            }
            if(valid) ans.add(s);
        }



        return ans;
    }
}
