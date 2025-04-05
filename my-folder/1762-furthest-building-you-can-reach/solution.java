class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int l = 0;
        int r = heights.length - 1;

        while (l <= r) {
            int mid = l +  (r - l) / 2;
            boolean wRizz = canReach(heights, bricks, ladders, mid);
            if (wRizz) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean canReach(int[] heights, int bricks, int ladders, int mid) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i <= mid; i++) {
            int diff = heights[i] - heights[i - 1];
            if(diff > 0){
                queue.offer(diff);
            }
        }

        while (!queue.isEmpty()) {
            int height = queue.poll();
            if (ladders > 0) {
                ladders--;
            } else {
                bricks -= height;
                if (bricks < 0)
                    return false;
            }
        }

        return true;
    }
}
