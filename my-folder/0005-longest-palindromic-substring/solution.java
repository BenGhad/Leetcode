class Solution {
    public String longestPalindrome(String s) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            queue.offer(new int[]{i, i});
            if(i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                queue.offer(new int[]{i, i + 1});
            }
        }
        int[] max = new int[]{0, 0};

        while(!queue.isEmpty()){
            int[] pal = queue.poll();
            int start = pal[0];
            int end = pal[1];
            if(max[1] - max[0] < end - start) {
                max[0] = start;
                max[1] = end;
            }
            if(start > 0 && end < s.length() - 1){
                if(s.charAt(start - 1) == s.charAt(end + 1)){
                    queue.offer(new int[]{start - 1, end + 1});
                }
            } 
        }

        return s.substring(max[0], max[1] + 1);

    }
}
