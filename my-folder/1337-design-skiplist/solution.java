class Skiplist {

    class Node {
        int val;
        Node next;
        Node down;
        Node up;

        public Node(int v, Node next, Node down, Node up) {
            val = v;
            this.next = next;
            this.down = down;
            this.up = up;
        }
    }

    Node head = new Node(-1, null, null, null);
    Node tail = head;
    Random rand = new Random();

    private boolean contains(Node n, int v) {
        while (n.next != null) {
            n = n.next;
            if (n.val == v)
                return true;
            if(n.val > v) return false;
        }
        return false;
    }

    private void addTo(Node n, int v) {
        while (n.next != null && n.next.val < v)
            n = n.next;
        n.next = new Node(v, n.next, null, null);
    }

    private boolean rmF(Node n, int v) {
        while (n.next != null && n.next.val < v) {
            n = n.next;
        }

        if (n.next != null && n.next.val == v) {
            n.next = n.next.next;
            return true;
        }
        return false;
    }

    public Skiplist() {

    }

    public boolean search(int target) {
        Node trav = tail;
        while (trav != null) {
            if (contains(trav, target))
                return true;
            trav = trav.up;
        }
        return false;
    }

    public void add(int num) {
        Node level = head;
        addTo(level, num);
        while (rand.nextDouble() > 0.5) {
            // uppies!
            if (level.down == null) {
                level.down = new Node(-1, null, null, level);
                tail = level.down;
            }
            level = level.down;
            addTo(level, num);
        }
    }

    public boolean erase(int num) {
        if (!search(num))
            return false;
        Node level = head;
        while (level != null && rmF(level, num))
            level = level.down;
        return true;
        // remove 1 from each level until we can't   
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
