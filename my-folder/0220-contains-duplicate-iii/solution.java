class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Map<Long, Long> bucket = new HashMap<>();
        long size = valueDiff + 1;

        for(int i = 0; i < nums.length; i++){
            long num = nums[i];
            long id = ID(num, size);

            if(bucket.containsKey(id)) return true;
            if(bucket.containsKey(id - 1) && 
            Math.abs(num - bucket.get(id - 1)) <= valueDiff) return true;
            if(bucket.containsKey(id + 1) &&
            Math.abs(num - bucket.get(id + 1)) <= valueDiff) return true;

            bucket.put(id, num);
            if(i >= indexDiff){
                long old = ID(nums[i - indexDiff], size);
                bucket.remove(old);
            }
        }
        return false;
    }

    private long ID(long num, long w){
        return num < 0 ? (num + 1) / w - 1 : num / w;
    }
}
