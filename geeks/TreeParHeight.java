/*
https://practice.geeksforgeeks.org/problems/height-using-parent-array4103/1/

Given a parent array arr[] of a binary tree of N nodes. Element at index i in the array arr[] represents the parent of ith node, i.e, arr[i] = parent(i). Find the height of this binary tree.
Note: There will be a node in the array arr[], where arr[i] = -1, which means this node is the root of binary tree.

Example 1:

Input: N = 7
arr = {-1, 0, 0, 1, 1, 3, 5}
Output: 5
Explanation: Tree formed is:
                    0
                   / \
                  1   2
                 / \
                3   4
               /
              5
             /
            6      Height of the tree= 5
Your Task:
You do not need to read input or print anything. Your task is to complete the function findHeight() which takes N and arr[] as input parameters and returns the height of the given binary tree.

Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 104
1 ≤ arr[i] ≤ 104   
*/
//sol
class Solution{
    static int findHeight(int n, int arr[]){
        // code here
        Arrays.sort(arr);
        arr[0]=1;
        int res = 1;
        for(int i=1;i<n;i++) {
            arr[i]=arr[arr[i]]+1;
            res=Math.max(res,arr[i]);
        }
        return res;
    }
}
/*
https://practice.geeksforgeeks.org/problems/exchange-the-leaf-nodes/1/

Given a binary tree of size N, your task is to complete the function pairwiseSwap(), that swap leaf nodes in the given binary tree pairwise starting from from left to right.
Example 1:

Input: 


Output: 7 2 1 4 5 9 3 8 6 10 

Explanation:
The sequence of leaf nodes in original binary tree
from left to right is (4, 7, 8, 9, 10). Now if we 
try to form pairs from this sequence, we will have 
two pairs as (4, 7), (8, 9). The last node (10) is 
unable to form pair with any node and thus left unswapped
 

Example 2:

Input: 
          1
       /     \
      2       3
       \    /    \
        5  6      7
Output: 2 6 1 5 3 7
        1
     /     \
    2       3
     \    /   \
      6  5     7
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function pairwiseSwap() which takes root node of the tree as input parameter.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1<=N<=103
1<=Data of a node <=103


*/
//sol
class Solution {
    int c=0;
    Node temp;
    public void pairwiseSwap(Node root){
        //code here
        if(root!=null) {
            if(root.left==null && root.right==null) {
                if(c==0) {
                    temp=root;
                    c++;
                }
                else {
                    int t=temp.data;
                    temp.data=root.data;
                    root.data=t;
                    c=0;
                }
            }
            pairwiseSwap(root.left);
            pairwiseSwap(root.right);
        }
    }
}
