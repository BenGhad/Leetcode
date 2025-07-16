class TimeMap {
    Map<String, Box> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key, new Box());
        }

        Box b = store.get(key);
        b.values.put(timestamp, value);
        b.timestamps.add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        Box b = store.get(key);
        if(b == null) return "";

        String val = b.values.get(b.timestamps.floor(timestamp));
        
        return val != null ? val : "";
    }

    private class Box{
        TreeSet<Integer> timestamps;
        Map<Integer, String> values;
        public Box(){
            timestamps = new TreeSet<>();
            timestamps.add(-1);
            values = new HashMap<>();
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
