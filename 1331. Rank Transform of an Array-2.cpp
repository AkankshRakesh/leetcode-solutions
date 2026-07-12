class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[][] temp = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            temp[i][0] = arr[i];
            temp[i][1] = i;
        }

        Arrays.sort(temp, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        int rank = 1;
        for(int i = 0; i < arr.length; i++){
            // System.out.println(temp[i][0] + " " + temp[i][1]);
            if(i != 0 && temp[i][0] == temp[i - 1][0]) arr[temp[i][1]] = arr[temp[i - 1][1]];
            else arr[temp[i][1]] = rank++;
        }

        return arr;
    }
}