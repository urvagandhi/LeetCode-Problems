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

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        /*
        nodes structure:
        vertical -> level -> minHeap(values)
        
        TreeMap is used so keys remain sorted automatically.
        */
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();

        /*
        BFS queue storing:
        node + its vertical index + level
        */
        Queue<Pair> todo = new LinkedList<>();

        // root starts at vertical = 0, level = 0
        todo.offer(new Pair(root, 0, 0));

        // Standard BFS traversal
        while (!todo.isEmpty()) {

            Pair p = todo.poll();

            TreeNode temp = p.node; // current node
            int x = p.vertical; // vertical position
            int y = p.level; // level (depth)

            /*
            Insert node into the map
            */

            // create vertical column if it doesn't exist
            nodes.putIfAbsent(x, new TreeMap<>());

            // create level if it doesn't exist
            nodes.get(x).putIfAbsent(y, new PriorityQueue<>());

            // add node value to min heap
            // priority queue ensures sorting when multiple nodes share same position
            nodes.get(x).get(y).offer(temp.val);

            /*
            Add children to BFS queue with updated coordinates
            */

            // left child -> vertical - 1
            if (temp.left != null) {
                todo.offer(new Pair(temp.left, x - 1, y + 1));
            }

            // right child -> vertical + 1
            if (temp.right != null) {
                todo.offer(new Pair(temp.right, x + 1, y + 1));
            }
        }

        // final result list
        List<List<Integer>> ans = new ArrayList<>();

        /*
        Traverse the TreeMap in sorted order of vertical columns
        */
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : nodes.values()) {

            List<Integer> col = new ArrayList<>();

            /*
            Traverse levels from top to bottom
            */
            for (PriorityQueue<Integer> pq : ys.values()) {

                /*
                Extract all values from the priority queue
                This ensures values with same position are sorted
                */
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }

            // add completed column to result
            ans.add(col);
        }

        return ans;
    }

    /*
    Helper class used in BFS queue
    Stores node and its coordinates
    */
    static class Pair {

        TreeNode node;
        int vertical;
        int level;

        Pair(TreeNode n, int v, int l) {
            node = n;
            vertical = v;
            level = l;
        }
    }
}