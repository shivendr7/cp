/*
https://leetcode.com/problems/largest-component-size-by-common-factor/

You are given an integer array of unique positive integers nums. Consider the following graph:

There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

 

Example 1:


Input: nums = [4,6,15,35]
Output: 4
Example 2:


Input: nums = [20,50,9,63]
Output: 2
Example 3:


Input: nums = [2,3,6,7,4,12,21,39]
Output: 8
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 105
All the values of nums are unique.
*/
//sol
/*
We maintain a union set where several elements are connected if and only if they have any common factor greater than 1.
We only have to connect each element in A with all its factors greater than 1, according to the nature of union set. 
We can do this by simply checking all the integers ranging from 2 to sqrt(A[i]).
*/
class Solution {
    
    int[] p;
    
    int get(int x){
        return p[x]==x ? x : (p[x]=get(p[x])) ;
    }
    
    void add(int x, int y){
        p[get(x)]=p[get(y)];
    }
    
    public int largestComponentSize(int[] A) {
        int mx=0;
        for(int i:A) mx=Math.max(i, mx);
        p=new int[mx+1];
        for(int i=1;i<=mx;++i) p[i]=i;
        for(int i:A)
            for(int j=(int)Math.sqrt(i);j>=2;--j)
                if(i%j==0){
                    add(i, j);
                    add(i, i/j);
                }
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        int res=0;
        for(int i:A){
            int j=get(i);
            if(!map.containsKey(j)) map.put(j, 1);
            else map.put(j, map.get(j)+1);
            res=Math.max(res, map.get(j));
        }
        return res;
    }
}
