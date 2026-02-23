class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> s = new Stack<>();

        boolean c = true;
        for(int i = digits.length - 1; i >= 0; i--){
            int d = digits[i];
            if(c){
                d += 1;
            }
            c = d==10;
            d %= 10;
            s.push(d);
        }

        ArrayList<Integer> num = new ArrayList<>();
        if(c) {num.add(1);}
        while(!s.isEmpty()){
            num.add(s.pop());
        }

        return num.stream().mapToInt(i -> i).toArray();
    }
}
