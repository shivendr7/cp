/*
https://practice.geeksforgeeks.org/problems/number-of-turns-in-binary-tree/1/

Given a binary tree and data value of two of its nodes. Find the number of turns needed to reach from one node to another in the given binary tree.

Example 1:

Input:      
Tree = 
           1
        /    \
       2       3
     /  \     /  \
    4    5   6    7                        
   /        / \                        
  8        9   10   
first node = 5
second node = 10
Output: 4
Explanation: 
Turns will be at 2, 1, 3, 6.
Example 2:

Input:      
Tree = 
           1
        /     \
       2        3
     /  \      /  \
    4    5    6    7                        
   /         / \                        
  8         9   10   
first node = 1
second node = 4  
Output: -1
Explanation: No turn is required since 
they are in a straight line.

Your Task:  
You don't need to read input or print anything. Complete the function NumberOFTurns() which takes root node and data value of 2 nodes as input parameters and returns the number of turns required to navigate between them. If the two nodes are in a straight line, ie- the path does not involve any turns, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of Tree)


Constraints:
1 ≤ N ≤ 103
*/
//sol
class Solution
{
    /* // Mine
    static int trav2(Node root, int f, boolean left, boolean right) {
        if(root==null) 
            return 0;
        if(root.data==f) 
            return 1;
        int l=trav2(root.left, f, true, false);
        int r=trav2(root.right, f, false, true);
        if(!left && !right) {
            if(l==0||r==0) return l+r;
            return l+r+1;
        }
        if(left) {
            if(l!=0 && r!=0) {
                return l+r+1;
            }
            if(l!=0) {
                return l;
            }
            if(r!=0)
                return r+1;
        }
        if(right) {
            if(l!=0 && r!=0) {
                return l+r+1;
            }
            if(r!=0) {
                return r;
            }
            if(l!=0)
                return l+1;
        }
        return 0;
    }
    static int trav(Node root, int first, int second, boolean left, boolean right) {
        if(root==null) return 0;
        if(root.data==first) {
            int val= trav2(root, second, false, false);
            //System.out.println(val);
            return val+1;
        }
        if(root.data==second) {
            int val= trav2(root, first, false, false);
            //System.out.println(val);
            return val+1;
        }
        int l=trav(root.left, first, second, true, false);
        int r=trav(root.right, first, second, false, true);
        
        if(!left && !right) {
            if(l==0||r==0) return l+r;
            return l+r+1;
        }
        if(left) {
            if(l!=0 && r!=0) {
                return l+r+1;
            }
            if(l!=0) {
                return l;
            }
            if(r!=0)
                return r+1;
        }
        if(right) {
            if(l!=0 && r!=0) {
                return l+r+1;
            }
            if(r!=0) {
                return r;
            }
            if(l!=0)
                return l+1;
        }
        return 0;
    }
    static int NumberOfTurns(Node root, int first, int second)
    {
        //your code here
        return trav(root, first, second, false, false)-2;
    }*/
    static Node lca (Node node, int a, int b){
        
        if (node == null)
            return null;
        
        if (node.data == a || node.data == b)
            return node;
            
        Node left = lca(node.left, a, b);
        
        Node right = lca(node.right, a, b);
        
        if (left == null)
            return right;
        
        if (right == null)
            return left;
            
        return node;
    }
    
    
    static int turnsRecur(Node node, int a, int b, int count, char direction){
        
        if (node == null)
            return -1;
            
        if (node.data == a || node.data == b)
            return count;
            
        int left;
            
        if (direction == 'l'){
            
            left = turnsRecur(node.left, a, b, count, direction);
            
            return (left != -1) ? left : turnsRecur(node.right, a, b, count + 1, 'r');
        } else {
            
            
            left = turnsRecur(node.left, a, b, count + 1, 'l');
                
            return (left != -1) ? left : turnsRecur(node.right, a, b, count, direction);
        }
    }
    
    
    static int NumberOfTurns(Node root, int first, int second)
    {
        //your code here
        
        Node lca = lca(root, first, second);
        
        int turns;
        
        if (lca.data == first){
            
            turns = turnsRecur(lca.left, second, second, 0, 'l');

            turns = (turns != -1) ? turns : turnsRecur(lca.right, second, second, 0, 'r');

            return (turns == 0) ? -1 : turns;            
            
        }else if (lca.data == second){
            
            turns = turnsRecur(lca.left, first, first, 0, 'l');

            turns = (turns != -1) ? turns : turnsRecur(lca.right, first, first, 0, 'r');

            return (turns == 0) ? -1 : turns;            
        }
        
        int a = turnsRecur(lca.left, first, second, 0, 'l');
        int b = turnsRecur(lca.right, first, second, 0, 'r');
        
        return a + b + 1;
    }
}
