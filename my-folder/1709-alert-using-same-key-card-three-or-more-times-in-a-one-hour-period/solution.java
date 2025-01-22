class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        List<Integer> queries = new ArrayList<>();
        for(int i = 0; i < n; i++){
            queries.add(i);
        }

        Collections.sort(queries, (a, b) -> {
            int c = keyName[a].compareTo(keyName[b]);
            if(c != 0){
                return c;
            } else {
                return convToMin(keyTime[a]) - convToMin(keyTime[b]);
            }
        });

        Set<String> set = new HashSet<>();

        for(int i = 2; i < n; i++){
            int q = queries.get(i);
            int q2 = queries.get(i - 2);
            if(!keyName[q2].equals(keyName[q])) continue;
            int time = convToMin(keyTime[q]);
            int prev = convToMin(keyTime[q2]);
            if(time - prev <= 60) set.add(keyName[q]);
        }
        List<String> ans = new ArrayList<String>(set);
        Collections.sort(ans);
        return ans;
        
    }

    public int convToMin(String time){
        //HH:MM
        int hours = Integer.parseInt(time.substring(0, 2)); 
        int minutes = Integer.parseInt(time.substring(3)); 
        return hours * 60 + minutes; 
    }
}
