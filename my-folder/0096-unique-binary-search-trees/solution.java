class Solution {
    int[] tree;
    public int numTrees(int n) {
        tree = new int[n + 1];
        tree[0] = 1;
        tree[1] = 1;

        return recurse(n);
    }

    public int recurse(int n){
        if(tree[n] != 0) return tree[n];
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans += recurse(i - 1) * recurse(n - i);
        }
        tree[n] = ans;
        return ans;
    }
}
