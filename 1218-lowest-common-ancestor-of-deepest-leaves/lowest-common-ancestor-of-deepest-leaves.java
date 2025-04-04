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
    TreeNode ans = null;
    int h = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        h = findHeight(root);
        lca(root, 1);
        return ans;
    }
    int findHeight(TreeNode node) {
        if(node == null)
            return 0;
        return Math.max(findHeight(node.left), findHeight(node.right)) + 1;
    }
    int lca(TreeNode node, int d) {
        if(node == null)
            return 0;
        int l = lca(node.left, d + 1);
        int r = lca(node.right, d + 1);
        if(l == r && d + l == h) {
            ans = node;
        }
        return Math.max(l, r) + 1;
    }
}