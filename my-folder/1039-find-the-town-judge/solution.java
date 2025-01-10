class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for(int i = 1; i <= n; i++){
            map.put(i, new HashSet<Integer>());
        }

        for(int[] t : trust){
            map.get(t[0]).add(t[1]);
        }

        int judge = -1;

        for(int i = 1; i <= n; i++){
            if(map.get(i).isEmpty()){
                if(judge > 0) return -1;
                judge = i;
            }
        }

        if(judge == -1) return judge;

        for(int i = 1; i <= n; i++){
            if(i == judge) continue;
            if(!map.get(i).contains(judge)) return -1;
        }

        return judge;
    }
}
