/*
Given N numbers in an array. Your task is to keep at-most K numbers at the top (According to their frequency).  We basically need to print top k numbers when input stream has included k distinct elements, else need to print all distinct elements sorted by frequency.

Example 1:

Input:
N=5, K=4
arr[] = {5, 2, 1, 3, 2} 
Output: 5 2 5 1 2 5 1 2 3 5 2 1 3 5 
Explanation:
Firstly their was 5 whose frequency
is max till now. so print 5.
Then 2 , which is smaller than 5 but
their frequency is same so print 2 5.
Then 1, which is smallet among all the
number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5
Then again 2, which has the highest
frequency among all number so 2 1 3 5.
Example 2:

Input:
N=5, K=4
arr[] = {5, 2, 1, 3, 4} 
Output: 5 2 5 1 2 5 1 2 3 5 1 2 3 4 
Explanation:
Firstly their was 5 whose frequency is
max till now. so print 5.
Then 2 , which is smaller than 5 but
their frequency is same so print 2 5.
Then 1, Which is smallest among all the
number arrived, so print 1 2 5.
Then 3 , so print 1 2 3 5.
Then 4, so 1 2 3 4 as K is 4 so print
at-most k elements.
 

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function kTop() that takes array a, integer n and integer k as parameters and returns the array that contains our desired output.

 

Expected Time Complexity: O(N*K).
Expected Auxiliary Space: O(N).

 

Constraints:
1 ≤ N,K ≤ 103
*/
//sol
class Solution
{ 
    static ArrayList<Integer> kTop(int[] a, int n, int k) 
    { 
        //code here.
        /* MINE
        ArrayList<Integer> ans=new ArrayList<>();
        int c[]=new int[k+1];
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++) {
            if(map.get(a[i])!=null) {
                map.put(a[i],map.get(a[i])+1);
            }
            else {
                map.put(a[i],1);
            }
            boolean found=false;
            for(int j=0;j<=k;j++) {
                if(found) {
                    c[j-1]=c[j];
                }
                else {
                    if(c[j]==a[i]) found=true;
                }
            }
            c[k]=a[i];
            for(int j=0;j<k;j++) {
                if(c[j]==0) {
                    c[j]=c[k];
                    ans.add(c[j]);
                    break;
                }
                int f1=map.get(c[j]),f2=map.get(c[k]);
                if(f1<f2) {
                    int temp=c[k];
                    c[k]=c[j];
                    c[j]=temp;
                }
                if(f1==f2 && c[j]>c[k]) {
                    int temp=c[k];
                    c[k]=c[j];
                    c[j]=temp;
                }
                ans.add(c[j]);
            }
        }
        return ans;
        */
        ArrayList<Integer> L=new ArrayList<>();
        L.add(Integer.valueOf(a[0]));
        for(int i=1;i<n;i++){
        Map<Integer,Integer> map=new HashMap<>();
        for(int t=0;t<=i;t++){
            map.put(a[t],map.getOrDefault(a[t],0)+1);
        }
        PriorityQueue<Integer> Q=new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                int f1=map.get(a);
                int f2=map.get(b);
                if(f1==f2)return Integer.compare(b,a);
                return f1-f2;
            }
        }
        );
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            
                Q.add(e.getKey());
            if(Q.size()>k){
            
                Q.poll();}
            
        }
        Stack<Integer> S=new Stack<>();
        
        while(!Q.isEmpty()){
            S.push(Q.poll());
        }
        while(!S.isEmpty()){
        L.add(S.pop());
        }
    }
    return L;
    }
}
