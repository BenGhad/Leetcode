class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        int r = 1;
        Arrays.sort(newArr);
        HashMap<Integer, Integer> hashy = new HashMap<Integer, Integer>();
        for(int i : newArr){
            if(!hashy.containsKey(i)){
                hashy.put(i, r);
                r++;
            }
        }
        

        for(int i = 0; i < arr.length; i++){
            int rank = hashy.get(arr[i]);
            newArr[i] = rank;
        }
        return newArr;

    }
}
