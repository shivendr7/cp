/*
https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1

Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Example 1:

Input:
     10
    /  \
   2   -25
  / \  /  \
 20 1  3  4
Output: 32
Explanation: Path in the given tree goes
like 10 , 2 , 20 which gives the max
sum as 32.
Example 2:

Input:
     10
   /    \
  2      5
          \
          -2
Output: 17
Explanation: Path in the given tree goes
like 2 , 10 , 5 which gives the max sum
as 17.
Your Task:
You don't need to take input or print anything. Your task is to complete the function findMaxSum() that takes root as input and returns max sum between any two nodes in the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ Number of nodes ≤ 103
1 ≤ |Data on node| ≤ 104


*/
//sol
class Solution
{
    int MAX;
    //Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node)
    {
        //your code goes here
        MAX=Integer.MIN_VALUE;
        int w=trav(node);
        return MAX;
    }
    int trav(Node root) {
        if(root==null) return 0;
        int l=trav(root.left);
        int r=trav(root.right);
        
        MAX=Math.max(MAX, root.data);
        MAX=Math.max(MAX, l+root.data);
        MAX=Math.max(MAX, r+root.data);
        MAX=Math.max(MAX, l+r+root.data);
        
        return Math.max(Math.max(l, r)+root.data, root.data);
    }
}
