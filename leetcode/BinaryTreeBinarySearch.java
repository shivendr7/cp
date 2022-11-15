/*
https://leetcode.com/problems/count-complete-tree-nodes/description/

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.
*/
// sol 1
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) 
            return 0;
        int l = 0, r = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            left = left.left;
            l++;
        }
        while (right != null) {
            right = right.right;
            r++;
        }
        if (l == r) 
            return (1<<l) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// sol 2
class Solution {
    public int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        if(root == null) 
            return 0;
        int h=height(root);
        return height(root.right) == h-1 ? 
            (1<<h) + countNodes(root.right) :
            (1<<h-1) + countNodes(root.left);
    }
}
