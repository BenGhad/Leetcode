class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for(int r = 0; r < fruits.length; r++){
            int fruit = fruits[r];
            count.put(fruit, count.getOrDefault(fruit, 0) + 1);
            while(count.size() > 2){
                int rm = fruits[l];
                int cnt = count.get(rm) - 1;
                if(cnt == 0){
                    count.remove(rm);
                } else{
                    count.put(rm, cnt);
                }
                l++;

            } 
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
