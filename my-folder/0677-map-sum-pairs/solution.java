class MapSum {
    private class Node{
        int val;
        char c;
        Node[] kids;
        public Node(int cnt, char c){
            this.val = cnt;
            this.c = c;
            kids = new Node[26];
        }
    }

    Map<String, Integer> values = new HashMap<>();
    Node head = new Node(0, '0'); 
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        int reduce = values.getOrDefault(key, 0);
        values.put(key, val);

        Node n = head;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);

            n.val += val - reduce; // update value

            if(n.kids[c-'a'] == null){
                n.kids[c-'a'] = new Node(0, c);
            }
            n = n.kids[c-'a'];
        }
        // am at the last node
        n.val += val - reduce;
    }
    
    public int sum(String prefix) {
        Node n = head;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);

            n = n.kids[c-'a'];
            if(n == null) return 0;
        }

        return n.val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
