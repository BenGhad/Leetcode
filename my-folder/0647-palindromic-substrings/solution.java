class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < n - 1; i++){
            queue.offer(new int[]{i, i});
            if(s.charAt(i) == s.charAt(i + 1)) queue.offer(new int[]{i, i + 1});   
        }
        queue.offer(new int[]{n - 1, n - 1});

        while(!queue.isEmpty()){
            int[] pal = queue.poll();
            int i = pal[0];
            int j = pal[1];
            ans++;
            if(i > 0 && j < n - 1 && s.charAt(i - 1) == s.charAt(j + 1)){
                queue.offer(new int[]{i - 1, j + 1});
            }
            

        }

        return ans;
    }
}
