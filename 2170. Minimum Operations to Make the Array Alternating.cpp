class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        unordered_map<int, int> evenFreq;
        unordered_map<int, int> oddFreq;

        for (int i = 0; i < nums.size(); i++) {
            if (i % 2 == 0) {
                evenFreq[nums[i]]++;
            } else {
                oddFreq[nums[i]]++;
            }
        }

        vector<int> evenTop = getTopTwo(evenFreq);
        vector<int> oddTop = getTopTwo(oddFreq);

        int evenCount = (nums.size() + 1) / 2;
        int oddCount = nums.size() / 2;

        if (evenTop[0] != oddTop[0]) {
            return (evenCount - evenTop[1])
                 + (oddCount - oddTop[1]);
        }

        int option1 = (evenCount - evenTop[1])
                    + (oddCount - oddTop[3]);

        int option2 = (evenCount - evenTop[3])
                    + (oddCount - oddTop[1]);

        return min(option1, option2);
    }

private:
    vector<int> getTopTwo(unordered_map<int, int>& freq) {
        int firstValue = -1;
        int firstFreq = 0;

        int secondValue = -1;
        int secondFreq = 0;

        for (auto& entry : freq) {
            int value = entry.first;
            int count = entry.second;

            if (count > firstFreq) {
                secondValue = firstValue;
                secondFreq = firstFreq;

                firstValue = value;
                firstFreq = count;
            } else if (count > secondFreq) {
                secondValue = value;
                secondFreq = count;
            }
        }

        return {firstValue, firstFreq, secondValue, secondFreq};
    }
};