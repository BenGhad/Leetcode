class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Arrays.sort(hand);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : hand) {
            if (map.getOrDefault(i, 0) == 0)
                continue;


            for (int j = 0; j < groupSize; j++) {
                int current = i + j;
                int freq = map.getOrDefault(current, 0);
                if (freq == 0)
                    return false;
                map.put(current, freq - 1);
            }

        }


        return true;
    }
}
