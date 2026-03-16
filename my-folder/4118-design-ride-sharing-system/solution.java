class RideSharingSystem {
    Queue<Integer> riders;
    Queue<Integer> drivers;
    boolean[] rye = new boolean[1067];
    public RideSharingSystem() {
        riders = new LinkedList<>();
        drivers = new LinkedList();
    }
    
    public void addRider(int riderId) {
        riders.offer(riderId);
        rye[riderId] = true;
    }
    
    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        while(!riders.isEmpty() && !rye[riders.peek()]){
            riders.poll();
        }

        if(riders.isEmpty() || drivers.isEmpty()) return new int[] {-1, -1};

        return new int[]{drivers.poll(), riders.poll()};
    }
    
    public void cancelRider(int riderId) {
        rye[riderId] = false;
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */
