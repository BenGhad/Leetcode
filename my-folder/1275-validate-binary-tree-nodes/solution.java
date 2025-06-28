class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            int l = leftChild[i];
            int r = rightChild[i];
            if (l != -1) {
                if (parent[l] != -1)
                    return false;
                parent[l] = i;
            }
            if (r != -1) {
                if (parent[r] != -1)
                    return false;
                parent[r] = i;
            }
        }

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                if (root != -1)
                    return false;
                root = i;
            }
        }
        if (root == -1)
            return false;


        // Cycle check:
        boolean[] seen = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(seen[u]) return false;
            seen[u] = true;
            if(leftChild[u] != -1) stack.push(leftChild[u]);
            if(rightChild[u] != -1) stack.push(rightChild[u]);
        }

        for(int i = 0; i < n; i++){
            if(!seen[i]) return false;
        }


        return true;

    }
}
