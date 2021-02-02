/*
Professor McGonagall teaches transfiguration at Hogwarts. 
She has given Harry the task of changing himself into a cat.
She explains that the trick is to analyze your own DNA and change it into the DNA of a cat.
The transfigure spell can be used to pick any one character from the DNA string, remove it and insert it in the beginning. 
Help Harry calculates minimum number of times he needs to use the spell to change himself into a cat.

A = "GEEKSFORGEEKS" 
B = "FORGEEKSGEEKS"
Output: 3
Explanation:The conversion can take place 
in 3 operations:
1. Pick 'R' and place it at the front, 
   A="RGEEKSFOGEEKS"
2. Pick 'O' and place it at the front, 
   A="ORGEEKSFGEEKS"
3. Pick 'F' and place it at the front, 
   A="FORGEEKSGEEKS"
   
CASES: A="ACDBE" B="ABCDE"


link:https://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/



hint: Start matching from last characters of both strings. 
If last characters match, then our task reduces to remaining characters.
If last characters don’t match, then find the position of B’s mismatching character in A. 
The difference between two positions indicates that these many characters of A must be moved.
*/

//sol:
class Solution
{
    int transfigure (String A, String B)
    {
    	// Your code goes here.
    	int f1[]=new int[58];
    	int f2[]=new int[58];
    	
    	if(A.length()!=B.length()) return -1;
    	
    	//A=A.toUpperCase();
    	//B=B.toUpperCase();
    	for(int i=0;i<A.length();i++) {
    	    try {
    	    f1[(int)A.charAt(i)-65]++;
    	    f2[(int)B.charAt(i)-65]++; }
    	    catch(Exception e) {
    	        System.out.println(A.charAt(i)+"  "+B.charAt(i));
    	    }
    	}
    	for(int i=0;i<26;i++) {
    	    if(f1[i]!=f2[i]) return -1;
    	}
    	int i=A.length()-1;
    	int j=i;
    	int res=0;
    	while(i>=0) {
    	    if(B.charAt(j)!=A.charAt(i)) {
    	        res++;
    	    }
    	    else {
    	        j--;
    	    }
    	    i--;
    	}
    	return (res);
    }
}
