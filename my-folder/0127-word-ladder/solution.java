class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
       Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++){
            for(int j = i + 1; j < wordList.size(); j++){
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                if(diff(word1, word2) == 1){
                    if(!map.containsKey(word1)) map.put(word1, new ArrayList());
                    if(!map.containsKey(word2)) map.put(word2, new ArrayList());
                   
                    map.get(word1).add(word2);
                    map.get(word2).add(word1);
                }
            }
        }

        return bfs(beginWord, endWord, map);
    }

    int diff(String word1, String word2){
        int count = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
                if(count > 1) return count;
            }
        }
        return count;
    }

    int bfs(String src, String dst, Map<String, List<String>> adj){
        int length = -1;
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet<>();
        queue.add(src);
        visited.add(src);

        while(!queue.isEmpty()){
            length++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                if(word.equals(dst)) return length + 1;
                if(!adj.containsKey(word)) continue;
                for(String w : adj.get(word)){
                    if(!visited.contains(w)){
                        queue.add(w);
                        visited.add(w);
                    }
                }
            }
        }
        return 0;

    }
}
