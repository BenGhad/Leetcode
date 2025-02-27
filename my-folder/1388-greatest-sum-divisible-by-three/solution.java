class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        PriorityQueue<Integer> ones = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> twos = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i : nums){
            sum += i;
            if(i % 3 == 1){
                ones.add(i);
                if(ones.size() > 2) ones.poll();
            }
            if(i % 3 == 2){
                twos.add(i);
                if(twos.size() > 2) twos.poll();
            }
        }
        int mod = sum % 3;
        if(mod == 1){
            int one = !ones.isEmpty() ? ones.poll() : Integer.MAX_VALUE;
            if(!ones.isEmpty()) one = ones.poll();
            int twoTwos = twos.size() >= 2 ? twos.poll() + twos.poll() : Integer.MAX_VALUE;
            sum -= Math.min(one, twoTwos);
        } else if (mod == 2){
            int two = !twos.isEmpty() ? twos.poll() : Integer.MAX_VALUE;
            if(!twos.isEmpty()) two = twos.poll();
            int oneOnes = ones.size() >= 2 ? ones.poll() + ones.poll() : Integer.MAX_VALUE;
            sum -= Math.min(two, oneOnes);
        }

        return sum;
    }
}
