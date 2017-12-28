/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // Given a binary tree, return all root-to-leaf paths.
 //
 // For example, given the following binary tree:
 //
 //    1
 //  /   \
 // 2     3
 //  \
 //   5
 // All root-to-leaf paths are:
 //
 // ["1->2->5", "1->3"]

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if (root == null) return res;
        helper(root, res, sb);
        return res;
    }

    private void helper(TreeNode root, List<String> res, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if (root.left != null) {
            sb.append(root.val);
            sb.append("->");
            helper(root.left, res, sb);
        }
        sb.setLength(len);
        if (root.right != null) {
            sb.append(root.val);
            sb.append("->");
            helper(root.right, res, sb);
        }
    }
}
