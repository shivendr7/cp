/*
link- https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1/?category[]=Binary%20Search%20Tree&category[]=Binary%20Search%20Tree&difficulty[]=1&page=1&query=category[]Binary%20Search%20Treedifficulty[]1page1category[]Binary%20Search%20Tree#
Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum. 

Example 1:

Input:
        2
      /   \
     1     3
sum = 5
Output: 1 
Explanation: 
Nodes with value 2 and 3 sum up to 5.
Example 2:

Input:
           6
          /    
         5     
        /
       3 
     /  \
    1    4
sum = 2
Output: 0 
Explanation: 
There's no pair that sums up to 2.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isPairPresent() that takes a root node and a target value as a parameter and returns 1 if there's a pair of Nodes in the BST with values summing up to the target sum, else returns 0. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1<=Number of Nodes<=100000
1<=K<=1000005
*/
//sol
class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        
        Stack<Node> norm=new Stack<>();
        Stack<Node> rev=new Stack<>();
        
        travLeft(root,norm);
        travRight(root,rev);
        
        Node p1=traverseNormal(norm);
        Node p2=traverseReverse(rev);
        
        while(!norm.empty()&&!rev.empty()) {
            
            //System.out.println(p1.data+p2.data);
            
            if(p1.data+p2.data<target) {
                p1=traverseNormal(norm);
            }
            else {
                if(p1.data+p2.data==target) {
                    return 1;
                }
                p2=traverseReverse(rev);
            }
        }
        return 0;
        
    }
    
    public Node traverseNormal(Stack<Node> st) {
        Node r=st.peek();
        st.pop();
        if(r.right!=null) {
            travLeft(r.right,st);
        }
        return r;
    }
    public Node traverseReverse(Stack<Node> st) {
        Node r=st.peek();
        st.pop();
        if(r.left!=null) {
            travRight(r.left,st);
        }
        return r;
    }
    
    public void travLeft(Node p,Stack<Node> st) {
        while(p!=null) {
            st.push(p);
            p=p.left;
        } 
    }
    public void travRight(Node p,Stack<Node> st) {
        while(p!=null) {
            st.push(p);
            p=p.right;
        } 
    }
}
