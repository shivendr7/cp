/*
link-https://practice.geeksforgeeks.org/problems/search-pattern0205/1/?category[]=Strings&category[]=Strings&difficulty[]=1&page=1&query=category[]Stringsdifficulty[]1page1category[]Strings#

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


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).


Constraints:
1<=|S|<=105
1<=|pat|<|S|
*/
class solution {
     public:
        vector <int> search(string pat, string txt)
        {
            //code hee.
            int n = txt.size(), m = pat.size() ;

            vector < int > lcs(m + 1, 0) ;
    
            auto kmp = [&](){
                int i = 1, j = 0 ;
                while(i < m){
                    if (txt[i] == txt[j]) lcs[i] = ++j ;
                    else j = 0 ;
                    ++i ;
                }
            };

            kmp() ; 

            vector < int > ans ;
            // for(auto x : lcs) cout << x << " " ;
            auto find = [&](){
                int i = 0, j = 0 ;
    
                while(i < n){
                    if (txt[i] == pat[j]){
                        i++ ;
                        j++ ;
                    // cout << j << " " ;
                        if (j == m){
                            ans.push_back(i - j + 1) ;
                            j = lcs[j - 1] ;
                        }
                    }
                    else {
                        if (!j) i++ ;
                        else j = lcs[j - 1] ;
                    }
        
                }
            };
    
            find() ;

            if (ans.empty()) ans.push_back(-1) ;
                return ans ;
       }
};
     
//java code
class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int m=pat.length(), n=txt.length();
        int lcs[]=new int[m+1];
        
        int i=1, j=0;
        while(i<m) {
            if(txt.charAt(i)==txt.charAt(j)) 
                lcs[i]=++j;
            else 
                j=0;
            i++;
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        i=0; j=0;
        while(i<n) {
            if(txt.charAt(i)==pat.charAt(j)) {
                i++;
                j++;
                if(j==m) {
                    ans.add(i-j+1);
                    j=lcs[j-1];
                }
            }
            else {
                if(j==0) 
                    i++;
                else
                    j=lcs[j-1];
            }
        }
        
        if(ans.size()==0) {
            ans.add(-1);
            return ans;
        }
        return ans;
    }
}
