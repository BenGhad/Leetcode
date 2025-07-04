class Solution {
    public boolean isFascinating(int n) {
        if(n > 329) return false;

        Set<Integer> set = new HashSet<>();

        if(!add(n, set)) return false;
        if(!add(n * 2, set)) return false;
        if(!add(n * 3, set)) return false;

        return true;
    }
    public boolean add(int n, Set<Integer> set){
        while(n > 0){
            if(!set.add(n % 10) || n % 10 == 0) return false;
            n /= 10;
        }

        return true;
    }
}
