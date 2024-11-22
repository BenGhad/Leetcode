class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int apples = 0;
        for(int i : apple){
            apples += i;
        }

        Arrays.sort(capacity);
        int box = 0;
        for(int i = capacity.length - 1; i >= 0; i--){
            box++;
            apples -= capacity[i];
            if(apples <= 0) return box;
        }
        return box;
    }
}
