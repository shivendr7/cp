/*
https://practice.geeksforgeeks.org/problems/5fbdb297e0fcb7703e7dee4b4f0ada9cc7e47bd8/1

Given a BST (Binary Search Tree), find the shortest range [x, y], such that, at least one node of every level of the BST lies in the range.
If there are multiple ranges with the same gap (i.e. (y-x)) return the range with the smallest x.

Example 1:

Input:
              8
          /   \
         3     10
       /  \      \
      2    6      14
          / \     /
         4   7   12
                /  \
               11   13
Output: 6 11
Explanation: Level order traversal of the tree 
is [8], [3, 10], [2, 6, 14], [4, 7, 12], [11, 13]. 
The shortest range which satisfies the above 
mentioned condition is [6, 11]. 

Example 2:

Input:
   12
    \
     13
       \
        14
         \
          15
           \
           16

Output: 12 16
Explanation: Each level contains one node, 
so the shortest range is [12, 16].

Your Task:
You don't need to read input or print anything. Complete the function shortestRange() which takes the root of the tree as an input parameter and returns the pair of numbers

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ Node Value ≤ 104
*/
//sol
class Solution {
    
    Node p1,p2;
    HashMap<Integer,Integer> map;
    int L[];
    int maxL;
    ArrayList<Integer> tree;
    
    public Range shortestRange(Node root) {
        // Your code goes here
        maxL=0;
        map=new HashMap<>();
        tree=new ArrayList<>();
        markLevels(root,map,0);
        L=new int[maxL+1];
        /*
        Stack<Node> travL=new Stack<>();
        traverseLeft(root,travL);
        Stack<Node> travR=new Stack<>();
        travR.push(root); L[0]++;
        */
        Range ans=new Range();
        ans.x=tree.get(0);
        ans.y=tree.get(tree.size()-1);
        /*
        p1=travL.peek(); p2=travR.peek();
        while(!travR.empty()) {
            if(!allPresent()) {
                p2=traverse(travR);
                System.out.println(p2.data);
            }
            else {
                if(Math.abs(ans.x-ans.y)>Math.abs(p1.data-p2.data)) {
                    ans.x=p1.data;
                    ans.y=p2.data;
                }
                p1=traverse(travL);
            }
        }
        return ans;*/
        int i=0,j=0; 
        for(i=0;i<tree.size();i++) {
            
            L[map.get(tree.get(i))]++;
            
            if(tree.get(i)==root.data) {
                j=i;
                break;
            }
        }
        i=0;
        
        while(i<tree.size()) {
            boolean found=true;
            for(int k=0;k<L.length;k++) {
                if(L[k]==0) {
                    found=false;
                    break;
                }
            }
            if(!found&&j<tree.size()-1) {
                
                L[map.get(tree.get(++j))]++;
                
            }
            else {
                if(found&&Math.abs(tree.get(i)-tree.get(j))<Math.abs(ans.y-ans.x)) {
                    ans.y=tree.get(j);
                    ans.x=tree.get(i);
                    
                }
                
                L[map.get(tree.get(i))]--;
                i++;
            }
        }
        return ans;
        
    }
    
    
    
    
    public void markLevels(Node root,HashMap<Integer,Integer> map,int l) {
        if(root==null) return;
        markLevels(root.left,map,l+1);
        
        map.put(root.data,l);
        tree.add(root.data);
        
        maxL=maxL>l?maxL:l;
        markLevels(root.right,map,l+1);
    }
}
