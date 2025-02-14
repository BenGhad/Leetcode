/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftovers = true;
        int end = -1;
        while (leftovers) {
            leftovers = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    leftovers = true;
                    sb.append(node.val + " ");
                    end = sb.length();
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append(". ");
                }
            }
        }
        return sb.substring(0, end - 1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] tokens = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < tokens.length) {
            TreeNode current = queue.poll();
            if (current != null) {
                // Process left child
                if (tokens[index].equals(".")) {
                    current.left = null;
                } else {
                    current.left = new TreeNode(Integer.parseInt(tokens[index]));
                    queue.offer(current.left);
                }
                index++;
                if (index >= tokens.length)
                    break; // Safety check

                // Process right child
                if (tokens[index].equals(".")) {
                    current.right = null;
                } else {
                    current.right = new TreeNode(Integer.parseInt(tokens[index]));
                    queue.offer(current.right);
                }
                index++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
