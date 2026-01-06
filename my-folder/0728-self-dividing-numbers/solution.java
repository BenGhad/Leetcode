class Solution {
    public boolean divides(int n){
        int nopy = n;
        List<Integer> digs = new ArrayList<>();
        while(nopy > 0){
            int unit = nopy % 10;
            if(unit == 0) return false;
            digs.add(unit);
            nopy /= 10;
        }

        for(int dig : digs){
            if(n % dig != 0) return false;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(divides(i)) ans.add(i);
        }
        return ans;
    }
}
