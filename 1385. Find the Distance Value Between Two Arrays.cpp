class Solution {
public:
    int findTheDistanceValue(vector<int>& arr1, vector<int>& arr2, int d) {
        int ans = 0;
        for(int num1 : arr1){
            bool valid = true;
            for(int num2 : arr2){
                if((num1 > num2 && num1 - num2 <= d) || (num1 <= num2 && num2 - num1 <= d)){
                    valid = false;
                    break;
                }
            }

            if(valid) ans++;
        }

        return ans;
    }
};