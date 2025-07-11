class Solution {
public:
    int bagOfTokensScore(std::vector<int>& tokens, int power) {
        std::sort(tokens.begin(), tokens.end());
        int n = tokens.size();
        if (n == 0) return 0;

        int score = 0;
        int left = 0, right = n - 1;

        if (tokens[0] > power && n == 1) return 0;

        while (left < right) {
            if (tokens[left] <= power) {
                power -= tokens[left];
                score++;
                left++;
            } else {
                if (score == 0) return 0;
                power += tokens[right];
                score--;
                right--;
            }
        }

        if (left == right && tokens[left] <= power) score++;

        return score;
    }
};
