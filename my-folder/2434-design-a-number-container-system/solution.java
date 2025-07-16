class NumberContainers {
    Map<Integer, TreeSet<Integer>> container; // map value to sorted indices
    Map<Integer, Integer> map; // map indice to value

    public NumberContainers() {
        container = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(!container.containsKey(number)){
            container.put(number, new TreeSet<>());
        }

        TreeSet<Integer> indices = container.get(number);

        if(!map.containsKey(index)){
            map.put(index, number);
            indices.add(index);

        } else {
            int rm = map.get(index);
            container.get(rm).remove(index);
            map.put(index, number);
            indices.add(index);
        }


    }
    
    public int find(int number) {
        TreeSet<Integer> indices = container.get(number);
        return (indices != null && !indices.isEmpty()) ? indices.first() : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
