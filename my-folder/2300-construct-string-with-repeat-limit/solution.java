class Solution {
    public String repeatLimitedString(String string, int repeatLimit) {
        int[] nums = new int[26];
        for(int i = 0; i < string.length(); i++){
            nums[string.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int r = 0;
        int s = 24;
        for(int i = 25; i >= 0; i--){
            while(nums[i] > 0){
                r = 0;
                if(!sb.isEmpty() && sb.charAt(sb.length() - 1) == (char)(i + 'a')) r++;
                while(r < repeatLimit && nums[i] > 0){
                    sb.append((char)(i + 'a'));
                    r++;
                    nums[i]--;
                }
                if(nums[i] > 0){
                    while(s >= 0 && nums[s] == 0){
                        s--;
                    }
                    if(s < 0) return sb.toString();
                    sb.append((char)(s + 'a'));
                    nums[s]--;
                }
            }
            s = i - 2;
        }


        return sb.toString();


    }
}
