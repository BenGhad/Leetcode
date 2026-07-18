class MyLinkedList {
    private class Node {
        int val;
        Node prv = null;
        Node nxt = null;
        public Node(int v){
            val = v;
        }
    }
    // 🤤
    Node dummyHead;
    Node dummyTail;
    int sz = 0;
    public MyLinkedList() {
        this.dummyHead = new Node(-1);
        this.dummyTail = new Node(-1);
        
        dummyHead.nxt = dummyTail;
        dummyTail.prv = dummyHead;
    }
    
    public int get(int index) {
        return getNode(index).val;
    }
    private Node getNode(int index){
        if(index >= sz || index < 0) return new Node(-1);
        Node n = dummyHead;
        for(int i = 0; i <= index; i++){
            n = n.nxt; 
        }
        return n;
    }
    public void addAtHead(int val) {
        Node old = dummyHead.nxt;
        Node nw = new Node(val);

        old.prv = nw;
        nw.nxt = old;

        dummyHead.nxt = nw;
        nw.prv = dummyHead;

        sz++;
    }
    
    public void addAtTail(int val) {
        Node old = dummyTail.prv;
        Node nw = new Node(val);

        old.nxt = nw;
        nw.prv = old;

        dummyTail.prv = nw;
        nw.nxt = dummyTail;

        sz++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0) {addAtHead(val); return; }
        if(index == sz) {addAtTail(val); return;}

        Node prv = getNode(index-1); // want to insert AFTER i-1 node
        if (prv.val == -1) return;

        Node nxt = prv.nxt;

        Node nw = new Node(val);

        prv.nxt = nw;
        nw.prv = prv;

        nw.nxt = nxt;
        nxt.prv = nw;
        
        sz++;
    }
    
    public void deleteAtIndex(int index) {
        Node rm = getNode(index);
        if(rm.val == -1) return;

        Node prv = rm.prv;
        Node nxt = rm.nxt;
        prv.nxt = nxt;
        nxt.prv = prv;

        sz--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
