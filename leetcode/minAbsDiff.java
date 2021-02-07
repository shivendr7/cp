/*
Not understood XD


Given an array int a[] and a goal g.
Find the minimum difference of goal from absolute sum of subsequences of the array.

Eg:
a=[1,2,3,4] g=-1
output: 1
subsequence:{} 
abs(-1 - 0)=1

*/
class Solution {
		public int minAbsDifference(int[] a, int goal) {
			int n = a.length;
			int h = n/2;
			int[] L = new int[1<<h];
			for(int i = 1;i < 1<<h;i++){
				L[i] += L[i&i-1] + a[Integer.numberOfTrailingZeros(i)];
			}
			Arrays.sort(L);
			int[] R = new int[1<<n-h];
			for(int i = 1;i < 1<<n-h;i++){
				R[i] += R[i&i-1] + a[h+Integer.numberOfTrailingZeros(i)];
			}
			int ans = Integer.MAX_VALUE;
			for(int v : R){
				int ind = Arrays.binarySearch(L, goal-v);
				if(ind >= 0)return 0;
				if(-ind-1 < L.length)ans = Math.min(ans, Math.abs(L[-ind-1] + v - goal));
				if(-ind-2 >= 0)ans = Math.min(ans, Math.abs(L[-ind-2] + v - goal));
			}
			return ans;
		}
	}
