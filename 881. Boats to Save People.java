class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int currWeight = 0;
        int ans = 0;
        int left = 0, right = n - 1;
        
        while(left < right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            }
            else{
                right--;
            }
            ans++;
        }
        if(left == right) ans++;

        return ans;
    }
}