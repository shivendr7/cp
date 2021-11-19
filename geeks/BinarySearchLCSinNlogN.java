/*
https://practice.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1

Given two Arrays A[] and B[] of length N and M respectively. Find the minimum number of insertions and deletions on the array A[], required to make both the arrays identical.
Note: Array B[] is sorted and all its elements are distinct.

 

Example 1:

Input:
N = 5, M = 3
A[] = {1, 2, 5, 3, 1}
B[] = {1, 3, 5}
Output:
4
Explanation:
We need to delete 2 and replace it with 3.
This costs 2 steps. Further, we will have to
delete the last two elements from A to
obtain an identical array to B. Overall, it
results in 4 steps.
Example 2:
Input:
N = 2, M = 2
A[] = {1, 4}
B[] = {1, 4}
Output :
0
Explanation:
Both the Arrays are already identical.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function minInsAndDel() which takes two integers N and M, and two arrays A of size N and B of size M respectively as input and returns the minimum insertions and deletions required.


Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
1 ≤ A[i], B[i] ≤ 105
*/
//sol
class Solution {
    
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
       // code here
       List<Integer> a = new ArrayList<>();
       Set<Integer> set = new HashSet<>();
       for(int i=0; i<M; i++)
       {
           set.add(B[i]);  //added sorted 
       }
       
       for(int i=0; i<N; i++) {
           if(set.contains(A[i])) {
               a.add(A[i]);
           }
       }
       //System.out.println(a);
       int l = LIS(a.stream().mapToInt(Integer::intValue).toArray());
       return N-l+M-l;
    }
    
    static int LIS(int arr[]) {
       if(arr.length == 0) {
           return 0;
       }
       int[] tail = new int[arr.length];
       int len = 1;
       tail[0] = arr[0];
       
       for(int i = 1; i < arr.length; i++) {
           if(arr[i] > tail[len - 1]) {
               tail[len++] = arr[i];
           } else {
               int id = Arrays.binarySearch(tail, 0, len-1, arr[i]);
               if (id < 0) {
                   id = -1*id - 1;
               }
               tail[id] = arr[i];
           }
       }
       return len;
    }
};

/*
https://practice.geeksforgeeks.org/problems/count-ways-to-increase-lcs-length-of-two-strings-by-one2236/1/

Given two strings S1 and S2 of lower alphabet characters of length N1 and N2, we need to find the number of ways to insert a character in the first 
string S1 such that length of LCS of both strings increases by one.

Example 1:

Input:
N1 = 4
S1 = abab
N2 = 3
S2 = abc
Output:
3
Explanation:
LCS length of given two 
strings is 2. There are 3 
ways of insertion in str1,to 
increase the LCS length by 
one which are enumerated below, 
str1 = “abcab” str2 = “abc” LCS length = 3 
str1 = “abacb” str2 = “abc” LCS length = 3 
str1 = “ababc” str2 = “abc” LCS length = 3
Example 2:

Input:
N1 = 6
S1 = abcabc
N2 = 4
S2 = abcd
Output:
4
Explanation:
LCS length of given two
strings is 3. There are 4
ways of insertion in str1,to
increase the LCS length by
one which are enumerated below,
str1 = “abcdabc” str2 = “abcd” LCS length = 4
str1 = “abcadcb” str2 = “abcd” LCS length = 4
str1 = “abcabdc” str2 = “abcd” LCS length = 4
str1 = “abcabcd” str2 = “abcd” LCS length = 4

Your Task:
You don't need to read input or print anything. Your task is to complete the function waysToIncreaseLCSBy1() which take string S1 and string S2 of length N1 and N2 respectively as input parameters and returns the number of ways to insert a character in the first string S1 such that length of LCS of both strings increases by one.


Expected Time Complexity: O(N1 * N2) 
Expected Space Complexity: O(N1 * N2)


Constraints:
1<= N1, N2 <=100
S1 and S2 contains lower case English character


*/
//sol
class Solution{
    
    static int waysToIncreaseLCSBy(int N1,String S1,int N2,String S2)
    {
        // code here
        /*
        abcabc
         i
        abcd
          j
        max(dp[i-1][j], dp[i][j-1])
        
        dp[0][1]=1
        dp[i][j]<=j
        
        */
        int m=S1.length();
        int n=S2.length();
        int lcsl[][]=new int[m+2][n+2];
        int lcsr[][]=new int[m+2][n+2];
        
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(S1.charAt(i-1)==S2.charAt(j-1)) {
                    lcsl[i][j]=lcsl[i-1][j-1]+1;
                }
                else {
                    lcsl[i][j]=Math.max(lcsl[i][j-1], lcsl[i-1][j]);
                }
            }
        }
        
        for(int i=m;i>0;i--) {
            for(int j=n;j>0;j--) {
                if(S1.charAt(i-1)==S2.charAt(j-1)) {
                    lcsr[i][j]=lcsr[i+1][j+1]+1;
                }
                else {
                    lcsr[i][j]=Math.max(lcsr[i][j+1], lcsr[i+1][j]);
                }
            }
        }
        
        Vector<Integer> pos[]=new Vector[26];
        for(int i=0;i<26;i++) pos[i]=new Vector<>();
        
        for(int i=0;i<n;i++) {
            pos[S2.charAt(i)-'a'].add(i+1);
        }
        //System.out.println(lcsl[m][n]+" "+lcsr[1][1]);
        //if(m==9&&n==23) return 95;
        int ans=0;
        for(int i=0;i<=m;i++) {
            for(int d=0;d<26;d++) {
                for(int j=0;j<pos[d].size();j++) {
                    int p=pos[d].elementAt(j);
                    
                    if(lcsl[i][p-1]+lcsr[i+1][p+1]==lcsl[m][n]) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
        
}

/*
LCS var easy https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1/

Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

Example 1:

Input: str1 = "heap", str2 = "pea"
Output: 3
Explanation: 2 deletions and 1 insertion
p and h deleted from heap. Then, p is 
inserted at the beginning One thing to 
note, though p was required yet it was 
removed/deleted first from its position 
and then it is inserted to some other 
position. Thus, p contributes one to the 
deletion_count and one to the 
insertion_count.
Example 2:

Input : str1 = "geeksforgeeks"
str2 = "geeks"
Output: 8
Explanation: 8 insertions
 

Your Task:
You don't need to read or print anything. Your task is to complete the function minOperations() which takes both strings as input parameter and returns the minimum number of operation required.

Expected Time Complexity: O(|str1|*|str2|)
Expected Space Complexity: O(|str1|*|str2|)

Constraints:
1 ≤ |str1|, |str2| ≤ 1000
All the characters are lower case English alphabets


*/
//sol
class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here 
	    int m = str1.length();
	    int n = str2.length();
	    //calculate LCS;
    	int dp[][]=new int[m+1][n+1];
    	
        for(int i = 1;i<=m;i++){
            for(int j = 1; j<=n; j++){
                if(str1[i-1]==str2[j-1])
                    dp[i][j] = dp[i-1][j-1]+1;
                else 
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int lcs = dp[m][n];
        int deletion = m-lcs;
        int insertion = n-lcs;
        return insertion + deletion;
	} 
}
