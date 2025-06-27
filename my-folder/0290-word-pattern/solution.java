class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        Map<Character, String> c2w = new HashMap<>();
        Map<String, Character> w2c = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String w = words[i];
            
            if(c2w.containsKey(c)){
                if(!c2w.get(c).equals(w)) return false;
            } else {
                if(w2c.containsKey(w)) return false;
                w2c.put(w, c);
                c2w.put(c, w);
            }
        }
        
        return true;
    }
    
    
    public boolean bipartite(Map<Integer, List<Integer>> adj, int n){
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        
        for(int i = 0; i < n; i++){
            if(color[i] >= 0) continue;
            color[i] = 0;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while(!queue.isEmpty()){
                int num = queue.poll();
                for(int neighbor : adj.get(num)){
                    if(color[neighbor] == color[num]) return false;
                    if(color[neighbor] != -1) continue;
                    color[neighbor] = (color[num] + 1) % 2;
                    queue.offer(neighbor);
                }
            }
            
        }
        
        return true;
    }
}
