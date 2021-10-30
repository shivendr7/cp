/*
https://www.interviewbit.com/problems/meeting-rooms/

Given an 2D integer array A of size N x 2 denoting time intervals of different meetings.

Where:

A[i][0] = start time of the ith meeting.
A[i][1] = end time of the ith meeting.
Find the minimum number of conference rooms required so that all meetings can be done.



Problem Constraints
1 <= N <= 10

0 <= A[i][0] < A[i][1] <= 2 * 109



Input Format
The only argument given is the matrix A.



Output Format
Return the minimum number of conference rooms required so that all meetings can be done.



Example Input
Input 1:

 A = [      [0, 30]
            [5, 10]
            [15, 20]
     ]

Input 2:

 A =  [     [1, 18]
            [18, 23]
            [15, 29]
            [4, 15]
            [2, 11]
            [5, 13]
      ]


Example Output
Output 1:

 2
Output 2:

 4


Example Explanation
Explanation 1:

 Meeting one can be done in conference room 1 form 0 - 30.
 Meeting two can be done in conference room 2 form 5 - 10.
 Meeting one can be done in conference room 2 form 15 - 20 as it is free in this interval.
Explanation 2:

 Meeting one can be done in conference room 1 from 1 - 18.
 Meeting five can be done in conference room 2 from 2 - 11.
 Meeting four can be done in conference room 3 from 4 - 15.
 Meeting six can be done in conference room 4 from 5 - 13.
 Meeting three can be done in conference room 2 from 15 - 29 as it is free in this interval.
 Meeting two can be done in conference room 4 from 18 - 23 as it is free in this interval.

*/
//sol
public class Solution {
    class Meet implements Comparator<Meet>, Comparable<Meet> {  //Comparator is not used
        int ini;
        int out;
        Meet(int i, int o) {
            ini=i;
            out=o;
        }
        public int compare(Meet a, Meet b) {
            return a.out-b.out;
        }
        public int compareTo(Meet a) {
            return this.ini-a.ini;
        }
    }
    public int solve(int[][] A) {
        if(A.length==0) return 0;
        ArrayList<Meet> ar=new ArrayList<>();
        for(int i=0;i<A.length;i++) {
            ar.add(new Meet(A[i][0], A[i][1]));
        }
        Collections.sort(ar);
        PriorityQueue<Meet> q=new PriorityQueue<>((a, b)-> a.out-b.out);  //Single dash in arrow function
        q.add(ar.get(0));
        int c=1;
        for(int i=1;i<ar.size();i++) {
            Meet out=ar.get(i);
            //System.out.println(q.peek().out+" "+ out.ini+" "+q);
            if(q.peek().out<=out.ini) {
                //System.out.println(out.ini);
                q.poll();
            }
            q.add(out);
            c=Math.max(c, q.size());
        }
        return c;
    }
}
