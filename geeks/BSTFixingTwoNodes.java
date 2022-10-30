/*
link-https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/0/?track=DSASP-BST&batchId=154#

Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed than the given input will form BST, except for 2 nodes that will be wrong.
 
Example 1:
Input:
       10
     /    \
    5      8
   / \
  2   20
Output: 1
Explanation:
 
Example 2:

Input:
         11
       /    \
      3      17
       \    /
        4  10
Output: 1 
Explanation: 
By swapping nodes 11 and 10, the BST 
can be fixed.
Your Task:
You don't need to take any input. Just complete the function correctBst() that takes root node as parameter. The function should return the root of corrected BST. BST 
will then be checked by driver code and 0 or 1 will be printed.

Expected Time Complexity : O(n)
Expected Auxiliary Space : O(1)
 
Constraints:
1 <= Number of nodes <= 1000

*/
//sol
class Sol
{
    Node fix1;
    Node fix2;
    Node p; //prev
    public Node correctBST(Node root)
    {
        //code here.
        p=null;
        fix1=null;
        fix2=null;
        traverse(root);
        int temp=fix1.data;
        fix1.data=fix2.data;
        fix2.data=temp;
        //System.out.println(fix1.data+" "+fix2.data);
        return root;
        
    }
 
    // mine
    public void traverse(Node root) {
        if(root!=null) {
            traverse(root.left);
            if(fix2!=null&&fix2.data>root.data) {
                fix2=root;
            }
            if(p!=null&&fix1==null&&p.data>root.data) {
                fix1=p;
                fix2=root;
            }
            p=root;
            traverse(root.right);
        }
    }
 
    // simple
    public void trav(Node root) {
     if (root != null) {
      trav(root.left);
      if (p != null and p.data>root.data) {
       if (fix1 == null) 
        fix1 = p;
       fix2 = root;
      }
      p = root;
      trav(root.right);
    }
}
