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
