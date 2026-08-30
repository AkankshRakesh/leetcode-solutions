class Solution {
public:
    TreeNode* dfs(TreeNode* node, int limit, int sum) {
        if (node == nullptr) {
            if (sum < limit) return new TreeNode(INT_MIN);
            return nullptr;
        }

        TreeNode* left = dfs(node->left, limit, sum + node->val);
        TreeNode* right = dfs(node->right, limit, sum + node->val);

        if (left == nullptr && right == nullptr)
            return node;
        else if (left != nullptr && right != nullptr) {
            if (left->val == INT_MIN && right->val == INT_MIN)
                return left;
            else if (left->val == INT_MIN) {
                node->left = nullptr;
                node->right = right;
            }
            else if (right->val == INT_MIN) {
                node->left = left;
                node->right = nullptr;
            }
            else {
                node->left = left;
                node->right = right;
            }
        }
        else if (left != nullptr) {
            if (left->val == INT_MIN)
                return left;
            else
                node->left = left;

            node->right = right;
        }
        else if (right != nullptr) {
            if (right->val == INT_MIN)
                return right;
            else
                node->right = right;

            node->left = left;
        }

        return node;
    }

    TreeNode* sufficientSubset(TreeNode* root, int limit) {
        root = dfs(root, limit, 0);

        if (root->val == INT_MIN)
            return nullptr;

        return root;
    }
};