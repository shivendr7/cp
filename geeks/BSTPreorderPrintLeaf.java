/*
https://practice.geeksforgeeks.org/problems/print-leaf-nodes-from-preorder-traversal-of-bst2657/1/

Given a preorder traversal of a BST, find the leaf nodes of the tree without building the tree.


Example 1:

Input:
N = 3
arr = {2, 4, 1}
Output: {1}
Explaination: 1 is the only leaf node.

Example 2:

Input:
N = 3
Arr = {3, 2, 4}
Output: {2, 4}
Explaination: 2, 4 are the leaf nodes.

Your Task:
You don't need to read input or print anything. Your task is to complete the function leafNodes() which takes the array arr[] and its size N as input parameters and returns the leaf nodes of the tree.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 103
*/
//sol
class Solution
{
    
    public int[] leafNodes(int preorder[], int n)
    {
        // code here
        
        ArrayList<Integer> ans=new ArrayList<>();
        /*
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<N;i++) {
            if(!st.empty() && st.peek()<arr[i]) {
                int out=st.pop();
                int c=0;
                while(!st.empty() && st.peek()<arr[i]) {
                    st.pop();
                    c++;
                }
                if(c>0) {
                    ans.add(out);
                    System.out.println(out+" "+i);
                }
            }
            st.push(arr[i]);
        }
        ans.add(st.pop());
        int ANS[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            ANS[i]=ans.get(i);
        }
        return ANS;
        */
        Stack<Integer> s = new Stack<Integer> ();  
        for (int i = 0, j = 1; j < n; i++, j++)  
        {  
            boolean found = false;  
            if (preorder[i] > preorder[j])  
                s.push(preorder[i]);  
            else
            {  
                while (!s.isEmpty())  
                {  
                    if (preorder[j] > s.peek())  
                    {  
                        s.pop();  
                        found = true;  
                    }  
                    else
                        break;  
                }  
            }  
            if (found)  
                ans.add(preorder[i]);
        }  
    
        ans.add(preorder[n-1]);
        int ANS[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            ANS[i]=ans.get(i);
        }
        return ANS; 
        
    }
    
}
