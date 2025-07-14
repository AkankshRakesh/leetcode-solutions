class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) return 0;

        queue<TreeNode*> q;
        q.push(root);
        int levels = 0;

        while (!q.empty()) {
            int n = q.size();
            while (n--) {
                TreeNode* ele = q.front();
                q.pop();
                if (ele->left) q.push(ele->left);
                if (ele->right) q.push(ele->right);
            }
            levels++;
        }

        return levels;
    }
};
