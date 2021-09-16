/*
https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1/

Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children in consideration and vice versa.

                                               

Example 1:

Input:
     11
    /  \
   1    2
Output: 11
Explanation: The maximum sum is sum of
node 11.
Example 2:

Input:
        1
      /   \
     2     3
    /     /  \
   4     5    6
Output: 16
Explanation: The maximum sum is sum of
nodes 1 4 5 6 , i.e 16. These nodes are
non adjacent.
Your Task:
You don't need to read input or print anything. You just have to complete function getMaxSum() which accepts root node of the tree as parameter and returns the maximum sum as described.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 ≤ N ≤ 1000

*/
//sol

class Pair{
    int included=0;
    int excluded=0;
    
    Pair(int included, int excluded){
        this.included = included;
        this.excluded = excluded;
    }
}
class Solution
{
    static int getMaxSum(Node root)
    {
        Pair p=getMaxSumUtil(root);
        return Math.max(p.included, p.excluded);
    }
    
    static Pair getMaxSumUtil(Node root){
        if(root==null)
            return new Pair(0, 0);
        if(root.left==null && root.right==null){
            return new Pair(root.data, 0);
        }
        Pair left = getMaxSumUtil(root.left);
        Pair right = getMaxSumUtil(root.right);
        int included = root.data + left.excluded + right.excluded;
        int excluded = Math.max(left.included, left.excluded) +
                    Math.max(right.included, right.excluded);
        
        left.included = included;
        left.excluded = excluded;
        return left; 
    }
}
