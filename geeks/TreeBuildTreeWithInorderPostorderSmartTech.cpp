/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
*/
//sol
class Solution {
    int i;
public:
    TreeNode *createTreeFromTraversal(vector<int>&in, vector<int>&post, int s, int e)
    {
        if (s > e)
        {
            return NULL;
        }
        //recursive case
        TreeNode *root= new TreeNode(post[i]);//build node from postorder  
        cout<<post[i]<<"\n";
        int index = -1;
        for (int j = s; j <= e; j++)
        {
            if (in[j] == post[i])
            {
                index = j;
                break;
            }
        }
        i--;
        root->right = createTreeFromTraversal(in, post, index + 1, e);
        cout<<"p\n";
        root->left = createTreeFromTraversal(in, post, s, index - 1);
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n=inorder.size();
        i=n-1;
        return createTreeFromTraversal(inorder,postorder,0,n-1);
    }
};
