class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            ArrayList<Integer> possibleInd =new ArrayList<>();
            for(int j = i + 1; j < n; j++){
                int comp = arr[i] - arr[j];
                if(comp < 0) comp = -comp;
                if(comp <= a) possibleInd.add(j);
            }
            for(int ind : possibleInd){
                for(int k = ind + 1; k < n; k++){
                    int comp1 = arr[ind] - arr[k];
                    int comp2 = arr[i] - arr[k];
                    if(comp1 < 0) comp1 = -comp1;
                    if(comp2 < 0) comp2 = -comp2;

                    if(comp1 <= b && comp2 <= c) ans++;
                }
            }
        }
        return ans;
    }
}