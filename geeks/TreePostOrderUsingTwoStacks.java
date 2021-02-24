/*
link-https://practice.geeksforgeeks.org/problems/postorder-traversal-iterative/1/?category[]=Stack&category[]=Stack&difficulty[]=1&page=1&query=category[]Stackdifficulty[]1page1category[]Stack#
Given a binary tree. Find the postorder traversal of the tree without using recursion.

Example 1

Input:
           1
         /   \
        2     3
      /  \
     4    5

Output: 4 5 2 3 1
Explanation:
Postorder traversal (Left->Right->Root) of 
the tree is 4 5 2 3 1.
Example 2

Input:
             8
          /      \
        1          5
         \       /   \
          7     10    6
           \   /
            10 6

Output: 10 7 1 6 10 6 5 8 
Explanation:
Inorder traversal (Left->Right->Root) 
of the tree is 10 7 1 6 10 6 5 8 .
 
Your task:
You don't need to read input or print anything. Your task is to complete the function postOrder() which takes the root of the tree as input and returns a list containing the postorder traversal of the tree, calculated without using recursion.
 
Expected time complexity: O(N)
Expected auxiliary space: O(N)
 
Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105

*/
//sol
class Tree {
    ArrayList<Integer> postOrder(Node node) {
        // code here
        Stack<Node> tree1=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Node> tree2=new Stack<>();
        tree1.push(node);
        while(!tree1.empty()) {
            Node c=tree1.pop();
            tree2.push(c);
            if(c.left!=null) {
                tree1.push(c.left);
            }
            if(c.right!=null) {
                tree1.push(c.right);
            }
        }
        while(!tree2.empty()) {
            ans.add(tree2.pop().data);
        }
        return ans;
    }    
}
