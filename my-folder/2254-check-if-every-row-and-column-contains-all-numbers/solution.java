class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int[] freq;
        for(int[] row : matrix){
            freq = new int[n];
            for(int i : row){
                if(freq[i - 1]++ != 0) return false;
            }
        }

        for(int i = 0; i < n; i++){
            freq = new int[n];
            for(int j = 0; j < n; j++){
                int val = matrix[j][i];
                if(freq[val  -1]++ != 0) return false;
            }
        }



        return true;
    }
}
