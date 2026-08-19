class Solution {
    public int maxNumberOfFamilies(int n, int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        int last = 0;
        int index = 0;
        while(index < arr.length){
            if(arr[index][0] - last > 1){
                ans += (2 * (arr[index][0] - last - 1));
            }
            last = arr[index][0];
    
            boolean[] takenSeats = new boolean[11];
            while(index < arr.length && arr[index][0] == last){
                takenSeats[arr[index][1]] = true;
                index++;
            }

            if((!takenSeats[1 + 1] && !takenSeats[2 + 1] && !takenSeats[3 + 1] && !takenSeats[4 + 1]) && (!takenSeats[5 + 1] && !takenSeats[6 + 1] && !takenSeats[7 + 1] && !takenSeats[8 + 1])) ans += 2;
            else if((!takenSeats[3 + 1] && !takenSeats[4 + 1] && !takenSeats[5 + 1] && !takenSeats[6 + 1]) || (!takenSeats[5 + 1] && !takenSeats[6 + 1] && !takenSeats[7 + 1] && !takenSeats[8 + 1]) || (!takenSeats[1 + 1] && !takenSeats[2 + 1] && !takenSeats[3 + 1] && !takenSeats[4 + 1])) ans++;
        }
        ans += 2 * (n - last);

        return ans;
    }
}