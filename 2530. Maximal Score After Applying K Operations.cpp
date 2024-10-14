class Solution {
public:
    long long maxKelements(vector<int>& nums, int k) {
        priority_queue<long long> pq;
        for(int i = 0; i < nums.size(); i++){
            pq.push(nums[i]);
        }
        long long score = 0;
        while(k){
            long long temp = pq.top();
            pq.pop();
            score += temp;
            if(temp % 3 == 0){
                temp /= 3;
            }
            else{
                temp /= 3;
                temp++;
            }

            pq.push(temp);
            k--;
        }
        return score;
    }
};