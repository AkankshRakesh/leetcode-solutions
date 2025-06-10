class Solution {
    public int maxDifference(String s) {
        int arr[] = new int[26];
        for(int i = 0; i < s.length(); i++) arr[s.charAt(i) - 'a']++;
        int maxOdd = 0, minEven = 100;

        for(int count : arr){
            // System.out.println(count);
            if(count == 0) continue;
            if(count == 1){
                if(maxOdd < count) maxOdd = count;
                continue;
            }

            if( count % 2 != 0){
                if(maxOdd < count) maxOdd = count;
                continue;
            }
            else if(minEven > count) minEven = count;
        }
        // System.out.println(maxOdd);
        // System.out.println(minEven);
        return maxOdd - minEven;
    }
}