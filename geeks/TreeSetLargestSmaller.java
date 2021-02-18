/*

Getting the largest smaller element uptil given index in an array.
*/

// Given array arr[n]


        int sgl[] = new int[n];
        
        //TreeSet stores in sorted order logn time using Tree dataset
        Set<Integer> S = new TreeSet<>();
        for(int i=0; i<n; i++){
            S.add(arr[i]);
            List<Integer> sglList = new ArrayList<>(S);
            int idx = sglList.indexOf(arr[i]);
            if (idx == 0){
                sgl[i] = -1;
            }
            else{
                sgl[i] = sglList.get(idx-1);
            }
        }
