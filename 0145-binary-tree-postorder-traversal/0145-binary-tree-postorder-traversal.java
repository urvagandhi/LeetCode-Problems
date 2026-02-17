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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode cur = root;

        while (cur != null || !st.isEmpty()) {

            // Go left as much as possible
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } 
            else {
                TreeNode temp = st.peek().right;

                // If right subtree does not exist
                if (temp == null) {
                    temp = st.pop();
                    res.add(temp.val);

                    // Keep popping while coming from right child
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        res.add(temp.val);
                    }
                } 
                // Otherwise go right
                else {
                    cur = temp;
                }
            }
        }

        return res;
    }
}
