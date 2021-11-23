/*
https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1/

Given a binary tree, find out whether it contains a duplicate sub-tree of size two or more, or not.


Example 1 :

Input : 
               1
             /   \ 
           2       3
         /   \       \    
        4     5       2     
                     /  \    
                    4    5
Output : 1
Explanation : 
    2     
  /   \    
 4     5
is the duplicate sub-tree.
Example 2 :

Input : 
               1
             /   \ 
           2       3
Output: 0
Explanation: There is no duplicate sub-tree 
in the given binary tree.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function dupSub() which takes root of the tree as the only arguement and returns 1 if the binary tree contains a duplicate sub-tree of size two or more, else 0.
Note: Two same leaf nodes are not considered as subtree as size of a leaf node is one.


Constraints:
1 ≤ length of string ≤ 100
*/
//sol
class Solution {
   int flag=0;
   Map<String,Integer>mp= new HashMap<>();
   int dupSub(Node root) {
       // code here 
       if(root == null)    return 0;
       find(root);
      return flag;
   }
   String find(Node root){
       if(root==null)return "s";
       String s="";
       s+=root.data;
       s+=find(root.left)+find(root.right);
       if(!mp.containsKey(s)){
           
       if(root.left!=null&&root.right!=null)
        mp.put(s,1);
       }
       else
        flag=1;
       return s;
   }
}

/*ISOMORHIC TREES
https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1/

Given two Binary Trees. Check whether they are Isomorphic or not.

Note: 
Two trees are called isomorphic if one can be obtained from another by a series of flips, i.e. by swapping left and right children of several nodes. Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.
For example, the following two trees are isomorphic with the following sub-trees flipped: 2 and 3, NULL and 6, 7 and 8.
ISomorphicTrees

Example 1:

Input:
 T1    1     T2:   1
     /   \        /  \
    2     3      3    2
   /            /
  4            4
Output: No

Example 2:

Input:
T1    1     T2:    1
    /  \         /   \
   2    3       3     2
  /                    \
  4                     4
Output: Yes
Your Task:
You don't need to read input or print anything. Your task is to complete the function isomorphic() that takes the root nodes of both the Binary Trees as its input and returns True if the two trees are isomorphic. Else, it returns False. (The driver code will print Yes if the returned values are true, otherwise false.)

 

Expected Time Complexity: O(min(M, N)) where M and N are the sizes of the two trees.
Expected Auxiliary Space: O(min(H1, H2)) where H1 and H2 are the heights of the two trees.

Constraints:
1<=Number of nodes<=105
*/
//sol
class Solution  
{ 
    // Return True if the given trees are isomotphic. Else return False.
    boolean isIsomorphic(Node root1, Node root2)  
    { 
         // code here. 
         if(root1==null && root2==null) return true;
         if(root1==null || root2==null) return false;
         if(root1.data==root2.data) {
             return isIsomorphic(root1.left, root2.left)
                 &&isIsomorphic(root1.right, root2.right)
                 ||
                 isIsomorphic(root1.right, root2.left)
                 &&isIsomorphic(root1.left, root2.right);
         }
         return false;
    }
    
}
