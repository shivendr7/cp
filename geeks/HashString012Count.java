/*
link- https://www.geeksforgeeks.org/substring-equal-number-0-1-2/

Given a string str of length N which consists of only 0, 1 or 2s, count the number of substring which have equal number of 0s, 1s and 2s.
 

Example 1:

Input: str = “0102010”
Output: 2
Explanation: Substring str[2, 4] = “102” and
substring str[4, 6] = “201” has equal number
of 0, 1 and 2 

 

Example 2:

Input: str = “11100022”
Output: 0
Explanation: There is no substring with
equal number of 0 , 1 and 2.
 

Your Task:  
You don't need to read input or print anything.Your task is to complete the function getSubstringWithEqual012() which takes a single string str as input and returns the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ N ≤ 105
*/
//sol
class Solution 
{ 
    long getSubstringWithEqual012(String s) 
    { 
        // code here
        long one=0, zero=0, two=0, ans=0;
        HashMap<String, Long> map=new HashMap<>();
        String t="0 0";
        map.put(t,(long)1);
        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            if(ch=='0') zero++;
            if(ch=='1') one++;
            if(ch=='2') two++;
            t=(zero-one)+" "+(zero-two);
            if(map.get(t)!=null) {
                ans+=map.get(t);
                map.put(t,map.get(t)+1);
            }
            else {
                map.put(t,(long)1);
            }
        }
        return ans;
    }
} 
