class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);

        if (numRows > 0){
            res.add(new ArrayList<>());
            res.get(0).add(1);
        }

        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>(i + 1);
            List<Integer> prev = res.get(i - 1);
            row.add(1); 
            for (int j = 1; j < i; j++){
                int num = prev.get(j) + prev.get(j-1);
                row.add(num);
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
