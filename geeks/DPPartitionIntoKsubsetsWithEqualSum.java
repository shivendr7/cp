/*
https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1

Given an integer array a[ ] of N elements and an integer K, the task is to check if the array a[ ] could be divided into K non-empty subsets with equal sum of elements.
Note: All elements of this array should be part of exactly one partition.

Example 1:

Input: 
N = 5
a[] = {2,1,4,5,6}
K = 3
Output: 
1
Explanation: we can divide above array 
into 3 parts with equal sum as (2, 4), 
(1, 5), (6)
â€‹Example 2:

Input: 
N = 5 
a[] = {2,1,5,5,6}
K = 3
Output: 
0
Explanation: It is not possible to divide
above array into 3 parts with equal sum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isKPartitionPossible() which takes the array a[], the size of the array N, and the value of K as inputs and returns true(same as 1) if possible, otherwise false(same as 0).

Expected Time Complexity: O(N*2N).
Expected Auxiliary Space: O(2N).

Constraints:
1 ≤ K ≤ N ≤ 10
1 ≤ a[i] ≤ 100
*/
//*******WRONG SOLUTION**********
class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	    int sum=0;
	    for(int i=0;i<n;i++) {
	        sum+=a[i];
	    }
	    int s=sum/k;
	    if(k==1) return true;
	    if(sum%k!=0) return false;
	    int dp[]=new int[s+1];
	    dp[0]=1;
	    Arrays.sort(a);
	    for(int i=0;i<n;i++) {
	        //dp[0]=1;
	        for(int j=a[i];j<=s;j++) {
	            if(dp[j-a[i]]>0) {
	                dp[j]++;
	                //dp[j-a[i]]--;
	            }
	        }
	        /*
	        for(int in=0;in<=s;in++) System.out.print(dp[in]+" ");
	        System.out.println();*/
	    }
	    /*
	    for(int i=0;i<=s;i++) System.out.print(dp[i]+" ");
	    System.out.println();*/
	    return dp[s]==n;
    }
}
/*
https://leetcode.com/problems/matchsticks-to-square/solution/

You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

 

Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
 

Constraints:

1 <= matchsticks.length <= 15
0 <= matchsticks[i] <= 109
*/
/*
Approach 2: Dynamic Programming
In any dynamic programming problem, what's important is that our problem must be breakable into smaller subproblems and also, these subproblems show some sort of overlap which we can save upon by caching or memoization.

Suppose we have 3,3,4,4,5,5 as our matchsticks that have been used already to construct some of the sides of our square (Note: not all the sides may be completely constructed at all times.)

If the square side is 88, then there are many possibilities for how the sides can be constructed using the matchsticks above. We can have

  (4, 4), (3, 5), (3, 5) -----------> 3 sides fully constructed.
  (3, 4), (3, 5), (4), (5) ---------> 0 sides completely constructed.
  (3, 3), (4, 4), (5), (5) ---------> 1 side completely constructed.
As we can see above, there are multiple ways to use the same set of matchsticks and land up in completely different recursion states.

This means that if we just keep track of what all matchsticks have been used and which all are remaining, it won't properly define the state of recursion we are in or what subproblem we are solving.

A single set of used matchsticks can represent multiple different unrelated subproblems and that is just not right.

We also need to keep track of number of sides of the square that have been completely formed till now.

Also, an important thing to note in the example we just considered was that if the matchsticks being used are [3,3,4,4,5,5][3,3,4,4,5,5] and the side of the square is 8, then we will always consider that arrangement that forms the most number of complete sides over that arrangement that leads to incomplete sides. Hence, the optimal arrangement here is (4, 4), (3, 5), (3, 5)(4,4),(3,5),(3,5) with 3 complete sides of the square.

Let us take a look at the following recursion tree to see if in-fact we can get overlapping subproblems.


Note: Not all subproblems have been shown in this figure. The thing we wanted to point out was overlapping subproblems.

We know that the overall sum of these matchsticks can be split equally into 4 halves. The only thing we don't know is if 4 equal halves can be carved out of the given set of matchsticks. For that also we need to keep track of the number of sides completely formed at any point in time. If we end up forming 4 equal sides successfully then naturally we would have used up all of the matchsticks each being used exactly once and we would have formed a square.

Let us first look at the pseudo-code for this problem before looking at the exact implementation details for the same.

let square_side = sum(matchsticks) / 4
func recurse(matchsticks_used, sides_formed) {
    if sides_formed == 4, then {
        Square Formed!!
    }
    for match in matchsticks available, do {
          add match to matchsticks_used
          let result = recurse(matchsticks_used, sides_formed)
          if result == True, then {
              return True
          }
          remove match from matchsticks_used
    }
    return False
}
This is the overall structure of our dynamic programming solution. Of-course, a lot of implementation details are missing here that we will address now.


Implementation Details

It is very clear from the pseudo-code above that the state of a recursion is defined by two variables matchsticks_used and sides_formed. Hence, these are the two variables that will be used to memoize or cache the results for that specific subproblem.

The question however is how do we actually store all the matchsticks that have been used? We want a memory efficient solution for this.

If we look at the question's constraints, we find that the max number of matchsticks we can have are 1515. That's a pretty small number and we can make use of this constraint.

All we need to store is which of the matchsticks from the original list have been used. We can use a Bit-Map for this

We will use NN number of bits, one for each of the matchsticks (NN is at max 15 according to the question's constraints). Initially we will start with a bit mask of all 1s and then as we keep on using the matchsticks, we will keep on setting their corresponding bits to 0.

This way, we just have to hash an integer value which represents our bit-map and the max value for this mask would be 2^{15}



Do we really need to see if all 4 sides have been completely formed ?

Another implementation trick that helps optimize this solution is that we don't really need to see if 4 sides have been completely formed.

This is because, we already know that the sum of all the matchsticks is divisible by 4. So, if 3 equal sides have been formed by using some of the matchsticks, then the remaining matchsticks would definitely form the remaining side of our square.

Hence, we only need to check if 3 sides of our square can be formed or not.



Complexity Analysis

Time Complexity : O(N \times 2^N)O(N×2 
N
 ). At max 2^N2 
N
  unique bit masks are possible and during every recursive call, we iterate our original matchsticks array to sum up the values of matchsticks used to update the sides_formed variable.

Space Complexity : O(N + 2^N)O(N+2 
N
 ) because NN is the stack space taken up by recursion and 4 \times 2^N4×2 
N
  = O(2^N)O(2 
N
 ) is the max possible size of our cache for memoization.

The size of the cache is defined by the two variables sides_formed and mask. The number of different values that sides_formed can take = 4 and number of unique values of mask = 2^N2 
N
 .
*/
//*****CORRECT SOLUTION************
import java.util.HashMap;

class Solution {

    // The memoization cache to be used during recursion.
    public HashMap<Pair<Integer, Integer>, Boolean> memo;

    // Array containing our matchsticks.
    public int[] nums;

    // Possible side of our square depending on the total sum of all the matchsticks. 
    public int possibleSquareSide;

    // Default constructor to initialise our memo cache.
    public Solution() {
        this.memo = new HashMap<Pair<Integer, Integer>, Boolean>();
    }

    // Main DP function.
    public boolean recurse(Integer mask, Integer sidesDone) {
        int total = 0;
        int L = this.nums.length;

        // The memo key for this recursion
        Pair<Integer, Integer> memoKey = new Pair(mask, sidesDone);

        // Find out the sum of matchsticks used till now.
        for(int i = L - 1; i >= 0; i--) {
            if ((mask&(1 << i)) == 0) {
                total += this.nums[L - 1 - i];
            }
        }

        // If the sum if divisible by our square's side, then we increment our number of complete sides formed variable.
        if (total > 0 && total % this.possibleSquareSide == 0) {
            sidesDone++;
        }

        // Base case.
        if (sidesDone == 3) {
            return true;
        }


        // Return precomputed results
        if (this.memo.containsKey(memoKey)) {
            return this.memo.get(memoKey);
        }

        boolean ans = false;
        int c = total / this.possibleSquareSide;

        // Remaining vlength in the current partially formed side.
        int rem = this.possibleSquareSide * (c + 1) - total;

        // Try out all remaining options (that are valid)
        for(int i = L - 1; i >= 0; i--) {
            if (this.nums[L - 1 - i] <= rem && (mask&(1 << i)) > 0) {
                if (this.recurse(mask ^ (1 << i), sidesDone)) {
                    ans = true;
                    break;
                }
            }
        }

        // Cache the computed results.
        this.memo.put(memoKey, ans);
        return ans;
    }

    public boolean makesquare(int[] nums) {

        // Empty matchsticks.
        if (nums == null || nums.length == 0) {
            return false;
        }

        // Find the perimeter of the square (if at all possible)
        int L = nums.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += nums[i];
        }

        int possibleSquareSide =  perimeter / 4;
        if (possibleSquareSide * 4 != perimeter) {
            return false;
        }

        this.nums = nums;
        this.possibleSquareSide = possibleSquareSide;
        return this.recurse((1 << L) - 1, 0);
    }
}
// https://leetcode.com/problems/matchsticks-to-square/discuss/1275514/Java-4-clean-codes-(Backtracking-Top-down-and-Bottom-up-DP)
/*
Solution using Backtracking
*/
#define ll long long
class Solution {
    public:
    ll sum=0;
    bool help(vector<int>& a, ll j, ll x, ll y, ll z, ll w){
        if(x>sum or y>sum or z>sum or w>sum) return false;
        if(j==a.size()) return (x==y) and (y==z) and (z==w); 
        return help(a,j+1,x+a[j],y,z,w) or help(a,j+1,x,y+a[j],z,w) or help(a,j+1,x,y,z+a[j],w) or help(a,j+1,x,y,z,w+a[j]);
        
    }
    bool makesquare(vector<int>& a) {
        for(auto x:a)sum+=x;
        if(a.size()<4 or sum%4!=0) return false;
        sort(a.begin(),a.end(),greater<int>());
        sum=sum/4;
        return help(a,0,0,0,0,0);
    }
};
