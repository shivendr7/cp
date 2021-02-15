/*
link- https://www.youtube.com/watch?v=qdeMliPI7po&feature=emb_logo 

Geek has developed an effective vaccine for Corona virus and he wants each of the N houses in Geek Land to have access to it. Given a binary tree where each node represents a house in Geek Land, find the minimum number of houses that should be supplied with the vaccine kit if one vaccine kit is sufficient for that house, its parent house and it's immediate child nodes.  

 

Example 1:

Input:
    1
   / \
  2   3 
        \
         4
          \
           5
            \
             6

Output:
2
Explanation:
The vaccine kits should be 
supplied to house numbers 1 and 5. 
Example 2:

Input:
    1
   / \
  2   3 
Output:
1
Explanation:
The vaccine kits should be 
supplied to house number 1.
*/
//sol
class Solution{
    static int vac;
    public static int supplyVaccine(Node root){
        // Your code goes here
        vac=0;
        boolean res[]=dfsTree(root);
        if(!res[1]||!res[1]) {
            vac++;
        }
        return vac;
        
    }
    public static boolean[] dfsTree(Node node) {
        boolean ans[]=new boolean[2];
        // pos 0 for houses with vaccine pos 1 for covered safely
        if(node==null) {
            ans[0]=false; ans[1]=true;
            return ans;
        }
        boolean[] left=dfsTree(node.left);
        boolean[] right=dfsTree(node.right);
        
        boolean coveredSafely=false,vaccinate=false;
        if(left[0]||right[0]) {
            coveredSafely=true;
        }
        //if anyone is not coveredSafely
        if(!left[1]||!right[1]) {
            vaccinate=true;
            vac++;
            coveredSafely=true;
        }
        ans[0]=vaccinate;
        ans[1]=coveredSafely;
        return ans;
    }
}
