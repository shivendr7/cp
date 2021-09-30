/*
https://practice.geeksforgeeks.org/problems/largest-bst/1/

Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.
Example 2:

Input: 6 6 3 N 2 9 3 N 8 8 2
            6
        /       \
       6         3
        \      /   \
         2    9     3
          \  /  \
          8 8    2 
Output: 2
Explanation: The following sub-tree is a
BST of size 2: 
       2
    /    \ 
   N      8
Your Task:
You don't need to read input or print anything. Your task is to complete the function largestBst() that takes the root node of the Binary Tree as its input and returns the size of the largest subtree which is also the BST. If the complete Binary Tree is a BST, return the size of the complete Binary Tree. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 ≤ Number of nodes ≤ 105
1 ≤ Data of a node ≤ 106
*/
//sol
class Solution{
    
    static class bst {
        boolean isbst; 
        int max, min, size;
        bst(boolean isbst, int max, int min, int size) {
            this.isbst=isbst;
            this.max=max;
            this.min=min;
            this.size=size;
        }
    }
    
    static int MAX;
    static {
        MAX=0;
    }
    static bst maxsize(Node root) {
        if(root==null) {
            return new bst(true, max, min, 0);
        }
        bst l=maxsize(root.left);
        bst r=maxsize(root.right);
        if(l.isbst && r.isbst && l.max<root.data && r.min>root.data) {
            return new bst(true, Math.max(r.max, root.data), Math.min(root.data, l.min), 1+l.size+r.size);
        }
        else {
            return new bst(false, Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(l.size, r.size));
        }
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        bst n=maxsize(root);
        return n.size;
    }
    
}
