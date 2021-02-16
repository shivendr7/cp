/*
link-https://practice.geeksforgeeks.org/problems/pairs-violating-bst-property/1/?category[]=Binary%20Search%20Tree&category[]=Binary%20Search%20Tree&difficulty[]=1&page=1&query=category[]Binary%20Search%20Treedifficulty[]1page1category[]Binary%20Search%20Tree#

You are given a Binary tree. You are required to find the number of pairs violating the BST property. In BST every element in left subtree must be less than every element in the right subtree. You are required to complete the function pairsViolatingBST(Node *root, int N).

 

Input:

The first line consists of an integer T denoting the number of test cases. Each test case consists of two lines. The first line of each test case consists of a single integer N, denoting the number of edges in the Binary tree. The next line contains the edges of the binary tree. Each edge consists of two integers and one character first of whose is parent node, second is child node and character "L" representing Left child and "R" representing the right child. 
 

Output:

You are required to complete the function pairsViolatingBST(Node *root, int N) which takes the root of the tree and the number of edges N as the arguments. The function returns the required number of pairs. As the results can be large, return your result modulo 10^9 + 7 

Constraints:

1 <= T <= 1000                

1 <= N < 10^5     

 

Example:

Input:

2

6

50 30 L 50 60 R 30 20 L 30 25 R 60 10 L 60 40 R

2

4 5 L 4 6 R

Output:

7

1

Explanation:

The binary tree for 1st test case is-

                  50

            /             \

      30                   60

    /     \                /      \

20          25           10       40

The pairs violating the BST property are: (20, 10), (25, 10), (30, 25), (30, 10), (50, 10), (50, 40), (60, 40). Hence, the result is 7.

 

The binary tree for 2nd test case is-

            4

     /              \

5                      6

The pair violating the BST property is: (5, 4). Hence, the result is 1.

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
 
*/

/*
hint-
Store the in-order traversal of the binary tree in an array. Now, 
count the number of inversions (i.e. a[i] > a[j] and i < j) in 
this array using Mergesort algorithm. The time complexity of this algorithm is O(nlogn).

*/
//code
class Solution {
    /*
    The structure of the node class is:
    class Node {
    int data;
    Node left, right;
        public Node(int data){
            this.data = data;
        }
    }
    */
    int inversions;
    public int pairs(Node root){
        //Write your code here
        ArrayList<Integer> tree=new ArrayList<>();
        traverse(tree,root);
        int T[]=new int[tree.size()];
        inversions=0;
        for(int i=0;i<tree.size();i++) {
            T[i]=tree.get(i);
        }
        int c[]=getInversions(T,0,T.length-1);
        return inversions;
    }
    
    public int[] getInversions(int a[],int start,int end) {
        int mid=(start+end)>>1;
        if(start==end) {
            int ans[]={a[start]};
            return ans;
        }
        if(end-start==1) {
            int ans[]=new int[2];
            if(a[start]>a[end]) {
                inversions+=1;
                ans[0]=a[end];
                ans[1]=a[start];
            }
            else {
                ans[0]=a[start];
                ans[1]=a[end];
            }
            return ans;
        }
        int left[]=getInversions(a,start,mid-1);
        int right[]=getInversions(a,mid,end);
        int i=0,j=0,k=0,ans[]=new int[left.length+right.length];
        while(i<left.length&&j<right.length) {
            if(left[i]<=right[j]) {
                ans[k++]=left[i++];
            }
            else {
                inversions+=left.length-i;
                ans[k++]=right[j++];
            }
        }
        while(i<left.length) {
            ans[k++]=left[i++];
        }
        while(j<right.length) {
            ans[k++]=right[j++];
        }
        return ans;
    }
    
    public void traverse(ArrayList<Integer> tree,Node root) {
        if(root!=null) {
            traverse(tree,root.left);
            tree.add(root.data);
            traverse(tree,root.right);
        }
    }

}
