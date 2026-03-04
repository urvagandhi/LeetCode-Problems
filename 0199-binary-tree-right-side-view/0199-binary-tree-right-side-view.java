/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        boolean leftToRight = true;

        while (!que.isEmpty()) {

            int size = que.size();          // nodes in this level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = que.poll();   // REMOVE front
                level.add(node.val);

                if (node.left != null)
                    que.add(node.left);

                if (node.right != null)
                    que.add(node.right);
            }
            
            Collections.reverse(level);   // reverse after level complete
            int first = level.get(0);
            res.add(first);
        }

        return res;
    }
}