class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }


        int max = Integer.MIN_VALUE;

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                if(i == j) continue;
                if(freq[i] == 0 || freq[j] == 0) continue;
                if(freq[i] % 2 == 1) continue;
                if(freq[j] % 2 == 0) continue;

                max = Math.max(freq[j] - freq[i], max);
            }
        }

        return max;
    }
}
