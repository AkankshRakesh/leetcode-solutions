class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();
        for(int ele : arr1){
            while(ele != 0){
                hs.add(ele);
                ele /= 10;
            }
        }
        
        int ans = 0;
        for(int ele : arr2){
            int digitLength = 0;
            int temp = ele;
            while(temp != 0){
                digitLength++;
                temp /= 10;
            }
            
            while(ele != 0){
                if(hs.contains(ele)) ans = Math.max(ans, digitLength);
                digitLength--;
                ele /= 10;
            }
        }

        return ans;
    }
}