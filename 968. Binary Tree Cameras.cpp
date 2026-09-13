class Solution {
private:
    vector<int> solve(TreeNode* node) {
        if (node == nullptr)
            return {10000, 0, 0};

        vector<int> left = solve(node->left);
        vector<int> right = solve(node->right);

        int camera = 1
                    + min(left[0], min(left[1], left[2]))
                    + min(right[0], min(right[1], right[2]));

        int covered = min(
            left[0] + min(right[0], right[1]),
            right[0] + min(left[0], left[1])
        );

        int notCovered = left[1] + right[1];

        return {camera, covered, notCovered};
    }

public:
    int minCameraCover(TreeNode* root) {
        vector<int> result = solve(root);
        return min(result[0], result[1]);
    }
};