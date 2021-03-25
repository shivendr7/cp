/*
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

 

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
 

Note:

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9

*/
/*
Idea:
The general principle here is easy to understand: for each value in B, we ideally want to pick a number from A that is just higher to match up against it. The naive way to do this would require sorting A, then iterating through it until we find the ideal number, then removing that number from A and moving it to the answer array (ans) at a time complexity of O(n^2).

We could employ a binary search instead of a straight iteration, which would drop the overall time complexity to O(n * log n), matching the sort time complexity. The issue that remains, however, is that getting rid of elements of A can be time-consuming. (Note: This method actually works well in Python; see the code below.)

Instead, if we had a sorted B as well, we could just match up the values very easily in descending order. If the largest remaining value of A is larger than the largest remaining value of B, then use it, otherwise, use the smallest remaining value of A, which is the least useful.

Since we need to return our answer matched up agains the original order of B, however, we can't just sort B. We can, however, create an index order lookup array and sort it in reference to the values in B, then use it as a bridge between the sorted A and unsorted B.

Once we've finished iterating, we can return ans.
*/
/*
Python Code w/ Binary Search:
The best result for the code below is 344ms / 16.6MB (beats 88% / 100%).

class Solution:
    def advantageCount(self, A: List[int], B: List[int]) -> List[int]:
        ans, A = [], sorted(A)
        for num in B:
            val = bisect_right(A, num)
            ans.append(A.pop(0) if val == len(A) else A.pop(val))
        return ans
*/

/*
Approach 1: Greedy
Intuition

If the smallest card a in A beats the smallest card b in B, we should pair them. Otherwise, a is useless for our score, as it can't beat any cards.

Why should we pair a and b if a > b? Because every card in A is larger than b, any card we place in front of b will score a point. We might as well use the weakest card to pair with b as it makes the rest of the cards in A strictly larger, and thus have more potential to score points.

Algorithm

We can use the above intuition to create a greedy approach. The current smallest card to beat in B will always be b = sortedB[j]. For each card a in sortedA, we will either have a beat that card b (put a into assigned[b]), or throw a out (put a into remaining).

Afterwards, we can use our annotations assigned and remaining to reconstruct the answer. Please see the comments for more details.
*/
//sol
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap();
        for (int b: B) assigned.put(b, new LinkedList());

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }
}
