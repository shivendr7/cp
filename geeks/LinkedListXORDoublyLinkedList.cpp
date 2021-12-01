/*
https://practice.geeksforgeeks.org/problems/xor-linked-list/1

An ordinary Doubly Linked List requires space for two address fields to store the addresses of previous and next nodes. A memory efficient version of Doubly Linked List can be created using only one space for address field with every node. This memory efficient Doubly Linked List is called XOR Linked List or Memory Efficient as the list uses bit-wise XOR operation to save space for one address.
Given stream of data of size N for the linked list, your task is to complete the function insert() and printList(). The insert() function pushes (or inserts at beginning) the given data in the linked list and the printList() function returns the linked list as a list.
Note: There is an utility function XOR() that takes two Node pointer to get the bit-wise XOR of the two Node pointer. Use this function to get the XOR of the two pointers.

Example 1:

Input:
LinkedList: 9<->5<->4<->7<->3<->10
Output:
10 3 7 4 5 9
9 5 4 7 3 10
Example 2:

Input:
LinkedList: 58<->96<->31
Output:
31 96 58
58 96 31
Your Task:
The task is to complete the function insert() and printList() as required.

Note: The driver code prints the returned list twice, once forward and once backward.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 100
*/
//sol
/*
Structure of linked list is as
struct Node
{
    int data;
    struct Node* npx;

    Node(int x){
        data = x;
        npx = NULL;
    }
};

Utility function to get XOR of two Struct Node pointer
use this function to get XOR of two pointers
struct Node* XOR (struct Node *a, struct Node *b)
{
    return (struct Node*) ((uintptr_t) (a) ^ (uintptr_t) (b));
}
*/

// function should insert the data to the front of the list

struct Node* insert(struct Node *head, int data)
{
   struct Node *new_node = new Node(data);
   new_node->npx = XOR(head,NULL);
   if (head!= NULL)
   {
   struct Node *next = XOR(head->npx, NULL);
   head->npx = XOR(new_node, next);
   }
   head = new_node;
}
vector<int> printList (struct Node *head)
{
   struct Node *curr = head;
   struct Node *prev = NULL;
   struct Node *next;
   vector<int> res;
   while (curr != NULL)
   {
   res.push_back(curr->data);
   next = XOR(prev, curr->npx);
   prev = curr;
   curr = next;
   }
   return res;
}
