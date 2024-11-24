class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(1);
        l2.add(1);
        l2.add(1);
        list.add(l1);
        if(numRows == 1) return list;
        list.add(l2);
        if(numRows == 2) return list;

        for(int i = 3; i <= numRows; i++){
            List<Integer> li = new ArrayList<>();
            li.add(1);
            for(int j = 0; j < i - 2; j++){
                int v = list.get(i - 2).get(j) + list.get(i - 2).get(j + 1); 
                li.add(v);
            }
            li.add(1);
            list.add(li);
        }

        return list;
    }
}
