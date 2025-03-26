class Solution {
    public int minOperations(int[][] grid, int x) {
        int mod = -1;
        List<Integer> candidates = new ArrayList<>();
        

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int num = grid[i][j];
                if(mod == -1){
                    mod = num % x;
                } else if(num % x != mod){
                    return -1;
                }
                candidates.add(num);
            }
        }    

        Collections.sort(candidates);

        int median = candidates.get(candidates.size() / 2);

        int op = 0;

        for(int num : candidates){
            op += Math.abs(num - median) / x;
        }

        return op;
        


    }
}
