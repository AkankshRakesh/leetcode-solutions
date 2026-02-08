class Solution {
    public int countSubarray(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        int sum = 0;
        hm.put(0, 1);
        for(int num : arr){
            if(num == 0) sum--;
            else sum++;
            
            if(hm.containsKey(sum)){
                ans += hm.get(sum);
                hm.put(sum, hm.get(sum) + 1);
            }
            else{
                hm.put(sum, 1);
            }
        }
        
        return ans;
    }
}