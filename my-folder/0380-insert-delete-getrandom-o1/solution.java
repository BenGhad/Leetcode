class RandomizedSet {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> list = new ArrayList<Integer>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
        }

        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        } else {
            int last = list.getLast();
            int index = map.get(val);

            map.put(last, index);
            list.set(index, last);
            map.remove(val);
            list.removeLast();
        }
        return true;
        
    }
    
    public int getRandom() {
        int random = (int)(Math.random() * list.size());

        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
