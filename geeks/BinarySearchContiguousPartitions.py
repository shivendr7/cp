"""
https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1#
https://www.youtube.com/watch?v=2JSQIhPcHQg

Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board is given by arr[i] where arr[] is an array of n integers. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board. 

The problem is to find the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or only board {1} or nothing but not boards {2,4,5}.


Example 1:

Input:
n = 5
k = 3
arr[] = {5,10,30,20,15}
Output: 35
Explanation: The most optimal way will be:
Painter 1 allocation : {5,10}
Painter 2 allocation : {30}
Painter 3 allocation : {20,15}
Job will be done when all painters finish
i.e. at time = max(5+10, 30, 20+15) = 35
Example 2:

Input:
n = 4
k = 2
arr[] = {10,20,30,40}
Output: 60
Explanation: The most optimal way to paint:
Painter 1 allocation : {10,20,30}
Painter 2 allocation : {40}
Job will be complete at time = 60

Your task:
Your task is to complete the function minTime() which takes the integers n and k and the array arr[] as input and returns the minimum time required to paint all partitions.


Expected Time Complexity: O(n log m) , m = sum of all boards' length
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n ≤ 105
1 ≤ k ≤ 105
1 ≤ arr[i] ≤ 105
"""
#sol
class Solution:
    def minTime (self, arr, n, k):
        #code here
        l=max(arr); r=sum(arr)
        ans=0
        while l<=r:
            mid=(l+r)>>1
            t=0; s=0
            
            for i in range(n):
                if s+arr[i]>mid:
                    t+=1
                    s=0
                s+=arr[i]
                
            if s:
                t+=1
            if t<=k:
                r=mid-1
                ans=mid
            else:
                l=mid+1
        return ans

    
    """
    https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
    
    Given a string word, return the sum of the number of vowels ('a', 'e', 'i', 'o', and 'u') in every substring of word.

A substring is a contiguous (non-empty) sequence of characters within a string.

Note: Due to the large constraints, the answer may not fit in a signed 32-bit integer. Please be careful during the calculations.

 

Example 1:

Input: word = "aba"
Output: 6
Explanation: 
All possible substrings are: "a", "ab", "aba", "b", "ba", and "a".
- "b" has 0 vowels in it
- "a", "ab", "ba", and "a" have 1 vowel each
- "aba" has 2 vowels in it
Hence, the total sum of vowels = 0 + 1 + 1 + 1 + 1 + 2 = 6. 
Example 2:

Input: word = "abc"
Output: 3
Explanation: 
All possible substrings are: "a", "ab", "abc", "b", "bc", and "c".
- "a", "ab", and "abc" have 1 vowel each
- "b", "bc", and "c" have 0 vowels each
Hence, the total sum of vowels = 1 + 1 + 1 + 0 + 0 + 0 = 3. 
Example 3:

Input: word = "ltcd"
Output: 0
Explanation: There are no vowels in any substring of "ltcd".
Example 4:

Input: word = "noosabasboosa"
Output: 237
Explanation: There are a total of 237 vowels in all the substrings.
 

Constraints:

1 <= word.length <= 105
word consists of lowercase English letters.

    """
    #sol
    class Solution:
    def countVowels(self, word: str) -> int:
        n=len(word)
        ans=0
        for i in range(0, n):
            s = word[i]
            if s in 'aeiou':
                ans += ((n - i) * (i + 1))           

        return ans
    
    """
    https://www.geeksforgeeks.org/count-of-substrings-consisting-of-even-number-of-vowels/
    
    Given a string S of length N, the task is to find the number of non-empty substrings having even number of vowels.
    
    Input: N = 5, S = “abcde”
Output: 7
Explanation: 
All possible substrings with even number of vowels are:
Substring              Vowels
{abcde}                     2
{b}                            0
{bc}                          0
{bcd}                        0
{c}                            0
{cd}                          0
{d}                           0
Input: N=4, S=”geeks”
Output: 6


    """
    #sol
    
def countSubstrings(s, n):
     
    # Stores the count of substrings
    # with even and odd number of
    # vowels respectively
    temp = [1, 0];
 
    result = 0;
    sum = 0;
    for i in range(0, n):
         
        # Update count of vowels modulo 2
        # in sum to obtain even or odd
        sum += (1 if isVowel(s[i]) else 0);
        sum %= 2;
 
        # Increment even/odd count
        temp[sum] += 1;
 
    # Count substrings with even number
    # of vowels using Handshaking Lemma
    result += ((temp[0] * (temp[0] - 1)) // 2);
    result += ((temp[1] * (temp[1] - 1)) // 2);
 
    print(result);
