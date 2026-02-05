class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int count = 0;
        int[] freq = new int[fruits.length];
        int left = 0;
        for(int right = 0; right < fruits.length; right++){
            freq[fruits[right]]++;
            if(freq[fruits[right]] == 1) count++;

            while(count > 2){
                freq[fruits[left]]--;
                if(freq[fruits[left]] == 0) count--;
                left++;
            } 

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}