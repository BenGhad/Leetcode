class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        right[0] = 0; 
        left[n - 1] = 0;

        int t = 0;
        for(int i = 1; i < n; i++){
            if(boxes.charAt(i - 1) == '1'){
                t++;
            }
            right[i] = right[i - 1] + t;
        }

        t = 0;
        for(int i = n - 2; i >= 0; i--){
            if(boxes.charAt(i + 1) == '1'){
                t++;
            }
            left[i] = left[i + 1] + t;
        }


        int[] ans = new int[n];
        for(int i = 0; i < ans.length; i++){
            ans[i] = left[i] + right[i];
        }
        return ans;
    }
}
