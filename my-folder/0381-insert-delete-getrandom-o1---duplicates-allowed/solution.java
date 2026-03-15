class RandomizedCollection {
    Map<Integer, Set<Integer>> pos;
    List<Integer> arr;
    Random rand = new Random();
    public RandomizedCollection() {
        pos = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean ans = !pos.containsKey(val);
        
        pos.computeIfAbsent(val, k -> new HashSet<>());
        pos.get(val).add(arr.size());
        
        arr.add(val);
        return ans;
    }
    
    public boolean remove(int val) {
        if(!pos.containsKey(val)) return false;

        int rmI = pos.get(val).iterator().next();
        pos.get(val).remove(rmI); // remove from set
        arr.set(rmI, arr.getLast()); // shift last back
        pos.get(arr.getLast()).add(rmI); // change of ID 
        pos.get(arr.getLast()).remove(arr.size() - 1); // remove old pos

        if(pos.get(val).isEmpty()) pos.remove(val);

        arr.removeLast();
        return true;
    }
    
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
