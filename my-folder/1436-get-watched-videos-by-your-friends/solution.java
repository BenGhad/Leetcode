class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        int[] deg = new int[n];
        Arrays.fill(deg, Integer.MAX_VALUE);
        deg[id] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int lev = 0;

        while (lev < level && !queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int person = queue.poll();
                for (int friend : friends[person]) {
                    if (deg[friend] == Integer.MAX_VALUE) { // Not visited yet
                        deg[friend] = lev + 1;
                        queue.offer(friend);
                    }
                }   
            }
            lev++;
        }

        // queue contains k friends, create list of their vids
        
    Map<String, Integer> frequencyMap = new HashMap<>();
    while (!queue.isEmpty()) {
        int friend = queue.poll();
        for (String video : watchedVideos.get(friend)) {
            frequencyMap.put(video, frequencyMap.getOrDefault(video, 0) + 1);
        }
    }

        List<String> sorted = new ArrayList<String>(frequencyMap.keySet());
        sorted.sort((a, b) -> {
            if (frequencyMap.get(a).equals(frequencyMap.get(b))) {
            return a.compareTo(b);
        }
         return frequencyMap.get(a) - frequencyMap.get(b);
        });

        return sorted;
    }
}
