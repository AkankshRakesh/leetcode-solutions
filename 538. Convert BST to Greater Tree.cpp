class Solution {
    int sum = 0;
public:
    void solve(TreeNode* node) {
        if (node == nullptr) return;

        solve(node->right);
        int prev = node->val;
        node->val += sum;
        sum += prev;
        solve(node->left);
    }

    TreeNode* convertBST(TreeNode* root) {
        solve(root);
        return root;
    }
};