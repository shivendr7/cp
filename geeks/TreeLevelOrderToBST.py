"""
https://practice.geeksforgeeks.org/problems/convert-level-order-traversal-to-bst/1/

Given an array of size N containing level order traversal of a BST. The task is to complete the function constructBst(), that construct the BST (Binary Search Tree) from its given level order traversal.

Example 1:

Input:
N = 9
BST[] = {7,4,12,3,6,8,1,5,10}
Output: 7 4 3 1 6 5 12 8 10
Explanation: After constructing BST, the
preorder traversal of BST is
7 4 3 1 6 5 12 8 10.
Example 2:

Input:
N = 6
BST[] = {1,3,4,6,7,8}
Output: 1 3 4 6 7 8
Explanation: After constructing BST, the
preorder traversal of BST is 1 3 4 6 7 8.
Your Task:
Your task is to complete the function constructBst() which has two arguments, first as the array containing level order traversal of BST and next argument as the length of array which return the root of the newly constructed BST. The preorder traversal of the tree is printed by the driver's code.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
"""
#sol
def constructBst(arr, n):
    #Your code here
    root = Node(arr[0])
    q=[[-10**9, root, 10**9]]
    i=1
    
    while i<n:
        
        minv=q[0][0]
        midv=q[0][1]
        maxv=q[0][2]
        
        q.pop(0)
        if arr[i]>minv and arr[i]<midv.data:
            midv.left = Node(arr[i])
            q.append([minv, midv.left, midv.data])
            i+=1
        if i<n and arr[i]>midv.data and arr[i]<maxv:
            midv.right = Node(arr[i])
            q.append([midv.data, midv.right, maxv])
            i+=1
        
    return root
