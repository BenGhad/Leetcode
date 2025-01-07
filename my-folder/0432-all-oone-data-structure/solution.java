class AllOne {
    class Bucket {
        int count;
        HashSet<String> keys;
        Bucket prev, next;
        Bucket(int c) {
            count = c;
            keys = new HashSet<>();
        }
    }
    
    private HashMap<String, Bucket> map = new HashMap<>();
    private Bucket head, tail;

    public AllOne() {}

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head == null) {
                Bucket b = new Bucket(1);
                b.keys.add(key);
                head = b;
                tail = b;
                map.put(key, b);
            } else if (head.count == 1) {
                head.keys.add(key);
                map.put(key, head);
            } else {
                Bucket b = new Bucket(1);
                b.keys.add(key);
                b.next = head;
                head.prev = b;
                head = b;
                map.put(key, b);
            }
        } else {
            Bucket b = map.get(key);
            b.keys.remove(key);
            int c = b.count + 1;
            if (b.next == null || b.next.count > c) {
                Bucket nb = new Bucket(c);
                nb.keys.add(key);
                nb.prev = b;
                nb.next = b.next;
                if (b.next != null) b.next.prev = nb;
                b.next = nb;
                map.put(key, nb);
                if (b == tail) tail = nb;
            } else {
                b.next.keys.add(key);
                map.put(key, b.next);
            }
            if (b.keys.isEmpty()) {
                if (b.prev != null) b.prev.next = b.next; else head = b.next;
                if (b.next != null) b.next.prev = b.prev; else tail = b.prev;
            }
        }
    }

    public void dec(String key) {
        Bucket b = map.get(key);
        b.keys.remove(key);
        int c = b.count - 1;
        if (c == 0) {
            map.remove(key);
        } else {
            if (b.prev == null || b.prev.count < c) {
                Bucket nb = new Bucket(c);
                nb.keys.add(key);
                nb.next = b;
                nb.prev = b.prev;
                if (b.prev != null) b.prev.next = nb; else head = nb;
                b.prev = nb;
                map.put(key, nb);
            } else {
                b.prev.keys.add(key);
                map.put(key, b.prev);
            }
        }
        if (b.keys.isEmpty()) {
            if (b.prev != null) b.prev.next = b.next; else head = b.next;
            if (b.next != null) b.next.prev = b.prev; else tail = b.prev;
        }
    }

    public String getMaxKey() {
        if (tail == null) return "";
        for (String s : tail.keys) return s;
        return "";
    }

    public String getMinKey() {
        if (head == null) return "";
        for (String s : head.keys) return s;
        return "";
    }
}

