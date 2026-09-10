class Solution {
    int ans = 0;

public:
    vector<int> traverse(TreeNode* node) {
        if (node == nullptr) return {0, 0};

        vector<int> left = traverse(node->left);
        vector<int> right = traverse(node->right);

        int n = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + node->val;

        if ((sum / n) == node->val) ans++;

        return {n, sum};
    }

    int averageOfSubtree(TreeNode* root) {
        traverse(root);
        return ans;
    }
};