class BrowserHistory {
    Node current;
    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node visited = new Node(url);
        current.next = visited;
        visited.prev = current;
        
        current = visited;
    }
    
    public String back(int steps) {
        int count = 0;
        while(count++ < steps && current.prev != null){
            current = current.prev;
        }
        return current.val;
    }
    
    public String forward(int steps) {
        int count = 0;
        while(count++ < steps && current.next != null){
            current = current.next;
        }
        return current.val;
    }
    
    private class Node{
        String val;
        Node prev;
        Node next;
        public Node(String v){
            val = v;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
