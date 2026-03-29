class Solution {
    int ans = INT_MIN;
public:
    int dfs(TreeNode* root) {
        if (root == nullptr) return 0;

        int left = dfs(root->left);
        int right = dfs(root->right);

        ans = max(ans, max(left + root->val + right, max(left + root->val, max(right + root->val, root->val))));

        return max(root->val + left, max(root->val + right, root->val));
    }

    int maxPathSum(TreeNode* root) {
        dfs(root);
        return ans;
    }
}; 