/*
https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1#


Given an array arr[ ] of size N, write a program that returns 1 if given array can represent preorder traversal of a possible BST, else returns 0.

Example 1:

Input:
N = 3
arr = {2, 4, 3}
Output: 1
Explaination: Given arr[] can represent
preorder traversal of following BST:
               2
                \
                 4
                /
               3
Example 2:

Input:
N = 3
Arr = {2, 4, 1}
Output: 0
Explaination: Given arr[] cannot represent
preorder traversal of a BST.
Your Task:
You don't need to read input or print anything. Your task is to complete the function canRepresentBST() which takes the array arr[] and its size N as input parameters and returns 1 if given array can represent preorder traversal of a BST, else returns 0.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ arr[i] ≤ 105
*/
//sol
class Solution {
    static int canRepresentBST(int arr[], int N) {
        // code here
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> h=new ArrayList<>();
        for(int i=0;i<N;i++) {
            while(!st.empty() && st.peek()<arr[i]) {
                h.add(st.pop());
            }
            st.push(arr[i]);
        }
        while(!st.empty()) {
            h.add(st.pop());
        }
        for(int i=1;i<h.size();i++) {
            if(h.get(i)<h.get(i-1)) return 0;
        }
        return 1;
    }
}
// Must see https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252232/JavaC%2B%2BPython-O(N)-Solution
