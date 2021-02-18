/*
link-https://practice.geeksforgeeks.org/problems/bst-to-max-heap/1/?category[]=Binary%20Search%20Tree&category[]=Binary%20Search%20Tree&difficulty[]=1&page=1&query=category[]Binary%20Search%20Treedifficulty[]1page1category[]Binary%20Search%20Tree#

Given a Binary Search Tree. Convert a given BST into a Special Max Heap with the condition that all the values in the left subtree of a node should be less than all the values in the right subtree of the node. This condition is applied on all the nodes in the so converted Max Heap.

Example 1:

Input :
                 4
               /   \
              2     6
            /  \   /  \
           1   3  5    7  

Output : 1 2 3 4 5 6 7 
Exaplanation :
               7
             /   \
            3     6
          /   \  /   \
         1    2 4     5
The given BST has been transformed into a
Max Heap and it's postorder traversal is
1 2 3 4 5 6 7.
Your task :
You don't need to read input or print anything. Your task is to complete the function convertToMaxHeapUtil() which takes the root of the tree as input and converts the BST to max heap.
Note : The driver code prints the postorder traversal of the converted BST.
 
Expected Time Complexity : O(n)
Expected Auxiliary Space : O(n)
 
Constraints :
1 <= n <= 10^5
*/
//sol
class Solution
{   
    public static void convertToMaxHeapUtil(Node root)
    {
        //code here
        Stack<Integer> tree=new Stack<>();
        extract(root,tree);
        store(root,tree);
        
    }
    public static void extract(Node root,Stack<Integer> tree) {
        if(root!=null) {
            extract(root.left,tree);
            tree.push(root.data);
            extract(root.right,tree);
        }
    }
    public static void store(Node root,Stack<Integer> tree) {
        if(root!=null) {
            root.data=tree.peek();
            tree.pop();
            store(root.right,tree);
            store(root.left,tree);
        }
    }
}
