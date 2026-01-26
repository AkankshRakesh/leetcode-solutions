class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(envelopes[0]);
        for(int i = 1; i < envelopes.length; i++){
            // System.out.println(envelopes[i][0] + "-" + envelopes[i][1]);
            if(arr.get(arr.size() - 1)[0] < envelopes[i][0] && arr.get(arr.size() - 1)[1] < envelopes[i][1]) arr.add(envelopes[i]);
            else{
                int left = 0;
                int right = arr.size();
                while(left < right){
                    int mid = left + (right - left) / 2;
                    
                    if(arr.get(mid)[0] >= envelopes[i][0] || arr.get(mid)[1] >= envelopes[i][1]) right = mid;
                    else left = mid + 1;
                }

                if(left < arr.size()) arr.set(left, envelopes[i]);
            }
        }

        return arr.size();
    }
}