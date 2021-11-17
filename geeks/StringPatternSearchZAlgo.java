/*
https://practice.geeksforgeeks.org/problems/8dcd25918295847b4ced54055eae35a8501181c1/1/

Given two strings, one is a text string and other is a pattern string. The task is to print the indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a string should be taken as 1.

Example 1:

Input:
S = "batmanandrobinarebat", pat = "bat"
Output: 1 18
Explanation: The string "bat" occurs twice
in S, one starts are index 1 and the other
at index 18. 
â€‹Example 2:

Input: 
S = "abesdu", pat = "edu"
Output: -1
Explanation: There's not substring "edu"
present in S.

Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes the string S and the string pat as inputs and returns an array denoting the start indices (1-based) of substring pat in the string S. 
Note: You don't need to return -1 yourself when there are no possible answers, just return an empty list.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).


Constraints:
1 ≤ |S| ≤ 105
1 ≤ |pat| ≤ |S|
*/
//so
class Solution
{
    
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here 
        ArrayList<Integer> res=new ArrayList<Integer>();
        String txt=pat;
        txt+="$"+S;
        //System.out.println(txt);
        int z[]=new int[txt.length()];
        int L=0;
        int R=0;
        for(int i=1;i<txt.length();i++){
            if(i>R){
                L=R=i;
                while(R<txt.length()&&txt.charAt(R)==txt.charAt(R-L))
                R++;
                z[i]=R-L;
                R--;
            }
            else{
                int i2=i-L;
                if(z[i2]<R-i+1)
                    z[i]=z[i2];
                else{
                    L=i;
                    while(R<txt.length()&&txt.charAt(R)==txt.charAt(R-L))
                    R++;
                    z[i]=R-L;
                    R--;
                }
            }
        }
        for(int i=0;i<z.length;i++){
            //System.out.print(z[i]);
            if(z[i]==pat.length())
            res.add(i-pat.length());
        }
        
        return res;
    }
}

/*
easy identify pattern 
https://practice.geeksforgeeks.org/problems/match-specific-pattern/1/

Given a dictionary of words and a pattern. Every character in the pattern is uniquely mapped to a character in the dictionary. Find all such words in the dictionary that match the given pattern. 

Example 1:

Input:
N = 4
dict[] = {abb,abc,xyz,xyy}
pattern  = foo
Output: abb xyy
Explanation: xyy and abb have the same
character at index 1 and 2 like the
pattern.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findMatchedWords() which takes an array of strings dict[] consisting of the words in the dictionary and a string, Pattern and returns an array of strings consisting of all the words in the dict[] that match the given Pattern in lexicographical order.

Expected Time Complexity: O(N*K) (where K is the length of the pattern).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 10

*/
//sol
class GfG
{
/* The function returns an array of strings 
present in the dictionary which matches
the string pattern.
You are required to complete this method */
public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
	{
	    //add code here. 
	     ArrayList<String> res=new ArrayList<String>();
          for(String word:dict){
              if(word.length()!=pattern.length()){
                  continue;
              }
              int hash1[]=new int[256];
              int hash2[]= new int[256];
              int i;
              for( i=0;i<word.length();i++){
                if(hash1[word.charAt(i)]==hash2[pattern.charAt(i)])  {
                    hash1[word.charAt(i)]++;
                    hash2[pattern.charAt(i)]++;
                }
                else{
                    break;
                }
              }
              if(i==word.length()){
                  res.add(word);
              }
          }
         return res;
	}
}
