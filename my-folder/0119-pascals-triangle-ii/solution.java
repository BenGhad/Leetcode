class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> list = new ArrayList<>(); // the triangle
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(1);
        l2.add(1);
        l2.add(1);
        list.add(l1);
        if(numRows == 0) return l1;
        list.add(l2);
        if(numRows == 1) return l2;

        for(int i = 3; i <= numRows + 1; i++){
            List<Integer> li = new ArrayList<>();
            li.add(1);
            for(int j = 0; j < i - 2; j++){
                int v = list.get(i - 2).get(j) + list.get(i - 2).get(j + 1); 
                li.add(v);
            }
            li.add(1);
            list.add(li);
        }

        return list.get(list.size() - 1);
    }
}
