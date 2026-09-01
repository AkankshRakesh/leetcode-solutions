public class Solution {
    public string LargestPalindromic(string num) {
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[10];
        for(int i = 0; i < num.Length; i++){
            freq[num[i] - '0']++;
        }

        for(int i = 9; i >= 0; i--){
            if(ans.Length == 0 && i == 0) break;
            if(freq[i] > 1){
                int times = freq[i] / 2;
                freq[i] -= times * 2;

                while(times != 0){
                    ans.Append(i);
                    times--;
                }
            }
        }

        bool singleDigitFound = false;
        for(int i = 9; i >= 0; i--){
            if(ans.Length == 0 && i == 0) return "0";
            if(freq[i] >= 1){
                freq[i]--;
                ans.Append(i);
                singleDigitFound = true;
                break;
            }
        }

        int index = singleDigitFound ? ans.Length - 2 : ans.Length - 1;
        while(index >= 0){
            ans.Append(ans[index]);
            index--;
        }

        return ans.ToString();
    }
}