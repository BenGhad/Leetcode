class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] col = new int[mat.length];
        int[] row = new int[mat[0].length];

        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int index = 0; index < arr.length; index++) {
            int i = arr[index];
            if(++col[map.get(i)[0]] == mat[0].length || 
            ++row[map.get(i)[1]] == mat.length) return index;
        }

        return -1;

    }
}
