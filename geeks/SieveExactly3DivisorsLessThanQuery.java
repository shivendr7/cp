/*
https://practice.geeksforgeeks.org/problems/3-divisors3942/1/

You have given a list of q queries and for every query, you are given an integer N.  The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

Example 1:

Input:
q = 1
query[0] = 6
Output:
1
Explanation:
There is only one number 4 which has
exactly three divisors 1, 2 and 4 and
less than equal to 6.
Example 2:

Input:
q = 2
query[0] = 6
query[1] = 10
Output:
1
2
Explanation:
For query 1 it is covered in the
example 1.
query 2: There are two numbers 4 and 9
having exactly 3 divisors and less than
equal to 10.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function threeDivisors() which takes an integer q and a list of integer of size q as input parameter and returns the list containing the count of the numbers having exactly 3 divisors for each query.

Expected Time Complexity: O(NlogN), 
Expected Auxiliary Space: O(N), where N is min(10^6,N)

Constraints :
1 <= q <= 103
1 <= query[i] <= 1012
*/
//sol Only squares of primes have exactly 3 divisors
class Solution{
    static int prime[];
    static {
        int n=10000001;
        boolean p[]=new boolean[n];
        for(int i=2;i<n;i++) {
            if(!p[i]) {
                for(int N=2*i;N<n;N+=i) {
                    p[N]=true;
                }
            } 
        }
        prime=new int[n];
        int k=0;
        for(int i=2;i<n;i++) {
            if(!p[i]) { 
                prime[k++]=i;
                //System.out.println(i);
            }
        }
    }
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<q;i++) {
            long val=(long)Math.sqrt(query.get(i));
            //System.out.println(val);
            int c=0;
            while(prime[c]<=(int)val) {
                c++;
            }
            ans.add(c);
        }
        return ans;
    }
}
