class FindSumPairs {
    int[] n1;
    int[] n2;
    Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        map = new HashMap<>();
        for(int i : nums2){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int rm = n2[index];
        map.put(rm, map.get(rm) - 1);
        n2[index] += val;
        int put = n2[index];
        map.put(put, map.getOrDefault(put, 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int num : n1){
            count += map.getOrDefault(tot - num, 0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
