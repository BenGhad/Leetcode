class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] first = s1.split(" ");
        String[] second = s2.split(" ");
        HashMap<String, Integer> hashy = new HashMap<>();
        ArrayList<String> sArr = new ArrayList<>();

        for(String s : first){
            int count = hashy.getOrDefault(s, 0);
            hashy.put(s, count + 1);
        }
        for(String s : second){
            int count = hashy.getOrDefault(s, 0);
            hashy.put(s, count + 1);
        }

        Set<String> setOfKeys = hashy.keySet();
        for(String key : setOfKeys){
            if(hashy.get(key) == 1){
                sArr.add(key);
            }
        }
        String[] ans = new String[sArr.size()];
        for(int i = 0; i < sArr.size(); i++){
            ans[i] = sArr.get(i);
        }
        return ans;


    }
}
