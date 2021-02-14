"""
link: https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1#
Given a binary tree, a target node in the binary tree, and an integer value k, find all the nodes that are at distance k from the given target node. No parent pointers are available.

Example 1:

Input :      
          20
        /    \
      8       22 
    /   \
   4    12 
       /   \
      10    14

Target Node = 8
K = 2

Output: 10 14 22

Explanation: The three nodes at distance 2
from node 8 are 10, 14, 22.



Example 2:

Input :      
         20
       /    \
      7      24
    /   \
   4     3
        /  
       1    

Target Node = 7
K = 2

Output: 1 24

Your Task:  
You dont need to read input or print anything. Complete the function KDistanceNodes() which takes the root of the tree, target and K as input parameters and returns a list of nodes at k distance from target. 


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)
"""
class solver:
    
    def KDistanceNodes(self,root,target,k):
        # code here
        # return the sorted list all nodes at k distance from target
        res=[]
        someval=self.getNodes(res,root,target,k)
        res.sort()
        return res
        
    def getNodesBelow(self,res,root,d,k):
        if root==None:
            return
        if d==k:
            res.append(root.data)
            return
        self.getNodesBelow(res,root.left,d+1,k)
        self.getNodesBelow(res,root.right,d+1,k)
        
    def getNodes(self,res,root,target,k):
        if root==None:
            return -1
        if root.data==target:
            self.getNodesBelow(res,root,0,k)
            return 0
        dl=self.getNodes(res,root.left,target,k)
        if dl!=-1 and dl<k:
            if dl+1==k:
                res.append(root.data)
                return dl+1
            if k-dl-1>0:
                self.getNodesBelow(res,root.right,0,k-dl-2)
            return dl+1
        dr=self.getNodes(res,root.right,target,k)
        if dr!=-1 and dr<k:
            if dr+1==k:
                res.append(root.data)
                return dr+1
            if k-dr-1>0:
                self.getNodesBelow(res,root.left,0,k-dr-2)
            return dr+1
        return -1
