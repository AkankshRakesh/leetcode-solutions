class Solution {
public:
    bool match(int* arr1, int* arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    bool checkInclusion(string s1, string s2) {
        int n = s1.size(), m = s2.size();
        if (n > m) return false;

        int arr1[26] = {0}, arr2[26] = {0};

        for (int i = 0; i < n; i++) arr1[s1[i] - 'a']++;
        for (int i = 0; i < n; i++) arr2[s2[i] - 'a']++;

        if (match(arr1, arr2)) return true;

        int left = 0;
        for (int i = n; i < m; i++) {
            arr2[s2[left++] - 'a']--;
            arr2[s2[i] - 'a']++;
            if (match(arr1, arr2)) return true;
        }

        return false;
    }
};
