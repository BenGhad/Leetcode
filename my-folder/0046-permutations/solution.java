class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        
        //base case:
        if(n == 1) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);
            list.add(l);
            return list; 
        }
    
        List<List<Integer>> ans  = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            
            int[] arr = new int[n - 1];
            for(int j = 0; j < n - 1; j++){
                if(j >= i) {
                    arr[j] = nums[j + 1];
                } else {
                    arr[j] = nums[j];
                }
            }

            List<List<Integer>> list = permute(arr);
            for(List<Integer> l : list){
                l.add(nums[i]);
            }
            ans.addAll(list);
        }

        return ans;
    }
}
