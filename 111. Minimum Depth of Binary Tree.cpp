/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == nullptr) return 0;

        queue<TreeNode*> q;
        q.push(root);
        int level = 1;
        int size = 1;

        while (!q.empty()) {
            TreeNode* top = q.front();
            q.pop();
            if (top->left == nullptr && top->right == nullptr) return level;

            if (top->left) q.push(top->left);
            if (top->right) q.push(top->right);

            size--;
            if (size == 0) {
                level++;
                size = q.size();
            }
        }

        return level;
    }
};
