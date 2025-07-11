class Solution {
public:
    int numRescueBoats(std::vector<int>& people, int limit) {
        std::sort(people.begin(), people.end());
        int n = people.size();
        int left = 0, right = n - 1;
        int ans = 0;

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            ans++;
        }

        if (left == right) ans++;  

        return ans;
    }
};
