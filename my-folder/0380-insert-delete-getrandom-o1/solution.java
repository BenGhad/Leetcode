class RandomizedSet {
    /*
    [1 4 2 5 8 9 ]
     0 1 2 3 4 5 
    
    [1 4 9 5 8 ]
     0 1 2 3 4
        


        
        list.remove(2)

        2 has index of 2
        

    */
    List<Integer> set = new ArrayList<Integer>();
    Map<Integer, Integer> map = new HashMap<>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        set.add(val);
        map.put(val, set.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int last = set.size() - 1;
        int lastVal = set.get(last);
        int idx = map.get(val);
        set.set(idx, lastVal);
        set.removeLast();
        map.put(lastVal, idx);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int random = (int)(Math.random() * set.size());
        return set.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
