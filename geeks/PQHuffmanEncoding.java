/*
link-https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1/

Given a string S of distinct character of size N and their corresponding frequency f[ ] i.e. character S[i] has f[i] frequency. Your task is to build the Huffman tree print all the huffman codes in preorder traversal of the tree.
Note: If two elements have same frequency, then the element which occur at first will be taken on the left of Binary Tree and other one to the right.

Example 1:

S = "abcdef"
f[] = {5, 9, 12, 13, 16, 45}
Output: 
0 100 101 1100 1101 111
Explanation:
HuffmanCodes will be:
f : 0
c : 100
d : 101
a : 1100
b : 1101
e : 111
Hence printing them in the PreOrder of Binary 
Tree.
Your Task:
You don't need to read or print anything. Your task is to complete the function huffmanCodes() which takes the given string S, frequency array f[ ] and number of characters N as input parameters and returns a vector of strings containing all huffman codes in order of preorder traversal of the tree.

Expected Time complexity: O(N * LogN) 
Expected Space complexity: O(N) 

Constraints:
1 ≤ N ≤ 26
*/
//sol
class Solution {
    
    static class Node{
        int freq;
        Node left, right;
        Node(int freq){
            this.freq = freq;
            this.left = this.right = null;
        }
    }
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.freq == o2.freq)
                    return 1;
                return Integer.compare(o1.freq, o2.freq);
                //return o1.freq-o2.freq;
            }
        });
        
        for(int i = 0;i < N;i++){
            pq.add(new Node(f[i]));
        }
        while (pq.size() != 1){
            Node first = pq.poll();
            Node second = pq.poll();
            Node newNode = new Node(first.freq + second.freq);
            newNode.left = first;
            newNode.right = second;
            pq.add(newNode);
        }
        ArrayList<String> list = new ArrayList<>();
        Node root = pq.peek();
        preOrder(root, "", list);
        return list;
    }
    
    void preOrder(Node root, String code, ArrayList<String> list){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            list.add(code);
        preOrder(root.left, code+"0", list);
        preOrder(root.right, code+"1", list);
    }
}
