class SeatManager {
    PriorityQueue<Integer> free;

    public SeatManager(int n) {
        free = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            free.offer(i);
        }
    }

    public int reserve() {
        int open = free.poll();

        return open + 1;
    }

    public void unreserve(int num) {
        free.offer(num - 1);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
