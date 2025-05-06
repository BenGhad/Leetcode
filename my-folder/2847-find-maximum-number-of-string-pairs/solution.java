class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<String>();
        for(String w : words){
            set.add(w);
        }
        int pairs = 0;
        for(String s : words){
            StringBuilder rev = new StringBuilder();
            rev.append(s);
            rev.reverse();
            String reverse = rev.toString();
            if(reverse.equals(s)) continue;
            if(set.contains(reverse)) pairs++;
        }


        return pairs / 2;
    }
}
