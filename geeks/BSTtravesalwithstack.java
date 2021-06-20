/*
link- https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1/

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
//cleaner code
/*
link-https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1

Given two BSTs, return elements of both BSTs in sorted form.

Example 1:

Input:
BST1:
       5
     /   \
    3     6
   / \
  2   4  
BST2:
        2
      /   \
     1     3
            \
             7
            /
           6
Output: 1 2 2 3 3 4 5 6 6 7
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        Stack<Node> st1=new Stack<>();
        Node c1=root1;
        Stack<Node> st2=new Stack<>();
        Node c2=root2;
        ArrayList<Integer> ans=new ArrayList<>();
        
        c1=trav(st1, c1);
        c2=trav(st2, c2);
        
        while(c1!=null||c2!=null) {
            if(c1==null) {
                ans.add(c2.data);
                c2=c2.right;
                c2=trav(st2, c2);
            }
            else if(c2==null) {
                ans.add(c1.data);
                c1=c1.right;
                c1=trav(st1, c1);
            }
            else {
                if(c1.data<c2.data) {
                    ans.add(c1.data);
                    c1=c1.right;
                    c1=trav(st1, c1);
                }
                else {
                    ans.add(c2.data);
                    c2=c2.right;
                    c2=trav(st2, c2);
                }
            }
        }
        
        return ans;
    }
    public Node trav(Stack<Node> s, Node curr) {
        if(curr==null&&s.size()==0) return null;
        while(curr!=null) {
            s.push(curr);
            curr=curr.left;
        }
        curr=s.pop();
        return curr;
    }
}
