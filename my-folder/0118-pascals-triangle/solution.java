class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++) ans.add(new ArrayList<>());
        
        //numrows >=1 
        ans.get(0).add(1);
        
        for(int j = 1; j < numRows; j++){
            List<Integer> prv = ans.get(j-1);
            List<Integer> cur = ans.get(j);
            
            cur.add(1);
            
            for(int i = 1; i < prv.size(); i++){
                cur.add(prv.get(i-1) + prv.get(i));
            }
            
            cur.add(1);
        }
        return ans;
    }
}
