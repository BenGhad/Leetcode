class RecentCounter {
    LinkedList<Integer> pings;
    public RecentCounter() {
        pings = new LinkedList<>();
    }
    
    public int ping(int t) {
        pings.add(t);
        while(pings.getFirst() < t - 3000){
            pings.removeFirst();
        }
        return pings.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
