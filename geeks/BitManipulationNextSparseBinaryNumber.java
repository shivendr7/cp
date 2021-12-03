/*
https://practice.geeksforgeeks.org/problems/next-sparse-binary-number0029/1/

Given an integer n in the input, find its next sparse binary number.A sparse binary number is a number whose binary representation does not contain any consecutive 1s.

Example 1:

Input: n = 3
Output: 4
Explanation: Binary representation of 4
is 0100.
Example 2:

Input: n = 5
Output: 5
Explanation: Binary representation of 5
is 0101.

Your Task:  
You dont need to read input or print anything. Complete the function nextSparse() which takes n as input parameter and returns the next sparse binary number.

Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(logn)

*/
//sol
/*
1) Find binary of the given number and store it in a 
   boolean array.
2) Initialize last_finalized bit position as 0.
2) Start traversing the binary from least significant bit.
    a) If we get two adjacent 1's such that next (or third) 
       bit is not 1, then 
          (i)  Make all bits after this 1 to last finalized
               bit (including last finalized) as 0. 
          (ii) Update last finalized bit as next bit. 
*/
import java.util.*;
 
class GFG{
static int nextSparse(int x)
{
    // Find binary representation of x and store it in bin.get(].
    // bin.get(0] contains least significant bit (LSB), next
    // bit is in bin.get(1], and so on.
    ArrayList<Integer> bin = new ArrayList<Integer>();
    while (x != 0)
    {
        bin.add(x&1);
        x >>= 1;
    }
 
    // There my be extra bit in result, so add one extra bit
    bin.add(0);
    int n = bin.size(); // Size of binary representation
 
    // The position till which all bits are finalized
    int last_final = 0;
 
    // Start from second bit (next to LSB)
    for (int i=1; i<n-1; i++)
    {
    // If current bit and its previous bit are 1, but next
    // bit is not 1.
    if (bin.get(i) == 1 && bin.get(i-1) == 1 && bin.get(i+1) != 1)
    {
            // Make the next bit 1
            bin.set(i+1,1);
 
            // Make all bits before current bit as 0 to make
            // sure that we get the smallest next number
            for (int j=i; j>=last_final; j--)
                bin.set(j,0);
 
            // Store position of the bit set so that this bit
            // and bits before it are not changed next time.
            last_final = i+1;
        }
    }
 
    // Find decimal equivalent of modified bin.get(]
    int ans = 0;
    for (int i =0; i<n; i++)
        ans += bin.get(i)*(1<<i);
    return ans;
}
 
// Driver program
public static void main(String[] args)
{
    int x = 38;
    System.out.println("Next Sparse Number is "+nextSparse(x));
}
}
