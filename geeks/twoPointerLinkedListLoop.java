/*
First Try Find Loop in Linked List 

You are given a linked list of N nodes. Remove the loop from the linked list, if present. 
Note: X is the position of the node to which the last node is connected to. If it is 0, then there is no loop.

Input:
N = 3
value[] = {1,3,4}
X = 2
Output: 1
Explanation: The link list looks like
1 -> 3 -> 4
     ^    |
     |____|    
A loop is present. If you remove it 
successfully, the answer will be 1.

Expected time complexity : O(n)
Expected auxiliary space : O(1)



Hint: 
Use the Hare Tortoise algorithm to find out if there is a loop.

A piece of code is run repeatedly in the Hare Tortoise algorithm, such that, with each execution,
the Hare pointer moves 2 nodes ahead and the tortoise pointer moves one node ahead in the linked list.
If the two meet, it means there is a loop in the list and the meeting node lies inside the loop.

Next, find the size of the loop.

Make one pointer stay at the meeting point of Hare Tortoise and use the other pointer to complete one round around the loop. 
Count the steps required to cover the loop.

Let s be the size of the loop.

Now we need 2 pointers again. The first pointer points at the head. Second pointer should be s nodes ahead.

Moves both pointers ahead step by step at same rate. This time the meeting point will be the junction node.
*/

//Sol
class solver
{
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node slow=head;
        Node fast=head.next;
        while(slow!=null&&fast!=null) {
            if(slow==fast) {
                int l=lengthLoop(slow);
                Node loophead=loopStart(head,l);
                int c=0;
                while(c<l-1) {
                    c++; loophead=loophead.next;
                } //loophead will now have loop's end
                loophead.next=null; //Making null
                break;
            }
            slow=slow.next;
            if(slow.next==null||fast.next==null) return;
            fast=fast.next.next;
        }
    }
    static int lengthLoop(Node node) {
        int c=0;
        Node New=node.next;
        while(New!=node) {
            New=New.next;
            c++;
        }
        return(c+1);
    }
    static Node loopStart(Node head,int l) {
        Node t1=head;
        int c=0;
        while(c<l) {
            c++; t1=t1.next;
        }
        Node t2=head;
        while(t1!=t2) {
            t1=t1.next;
            t2=t2.next;
        }
        return t2;
    }
}
