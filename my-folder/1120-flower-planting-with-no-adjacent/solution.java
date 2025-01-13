class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 1; i <= n; i++){
            map.put(i, new HashSet<Integer>());
        }
        for(int[] path : paths){
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }

        for(int i = 0; i < ans.length; i++){
            int[] possible = new int[5];
            for(int j : map.get(i + 1)){
                possible[ans[j - 1]]++;
            }
            for(int j = 1; j < 5; j++){
                if(possible[j] == 0){
                    ans[i] = j;
                    break;
                }
            }
        }
        

        return ans;
        


        /* W answer:
        
        for(int i = 0; i < n; i++){
            if(ans[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(i + 1);

            while(!queue.isEmpty()){
                int garden = queue.poll();
                int[] possible = new int[5];

                for(int neighbor : map.get(garden)){
                    int guy = ans[neighbor - 1];
                    possible[guy]++; 
                    if(guy == 0) queue.offer(neighbor);
                }
                for(int j  = 1; j < 5; j++){
                    if(possible[j] == 0){
                        ans[garden - 1] = j;
                        break;
                    }
                }

            }
        }
        return ans;
        */
    }
}
