class Solution {
    public int countAtMostK(int arr[], int k) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left = 0;
        int ans = 0;
        
        for(int right = 0; right < arr.length; right++){
            if(hm.containsKey(arr[right])) 
                hm.put(arr[right], hm.get(arr[right]) + 1);
            else{
                hm.put(arr[right], 1);
                count++;
            }
            
            while(count > k){
                hm.put(arr[left], hm.get(arr[left]) - 1);
                if(hm.get(arr[left]) == 0){
                    count--;
                    hm.remove(arr[left]);
                }
                
                left++;
            }
            
            ans += right - left + 1;
        }
        
        return ans;
    }
}
